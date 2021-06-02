package NIO通信;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author fangsheng
 * @date 2021/5/27 3:11 下午
 */
public class GroupChatServer {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private static final int PORT = 6666;

    public GroupChatServer() {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        try {
            while (true) {
                int count = selector.select();
                if (count > 0) {
                    Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();
                    while (selectionKeyIterator.hasNext()) {
                        SelectionKey selectionKey = selectionKeyIterator.next();
                        //public final boolean isAcceptable(),isReadable(),isWritable(),isConnectable()
                        //用于判断这个SelectionKey产生的是什么事件，与上面的事件类型一一对应
                        if (selectionKey.isAcceptable()) {
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector, SelectionKey.OP_ACCEPT);
                            System.out.println(socketChannel.getRemoteAddress() + "上线...");
                        }
                        if (selectionKey.isReadable()) {
                            readData(selectionKey);
                        }
                        selectionKeyIterator.remove();
                    }
                } else {
                    System.out.println("等待...");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void readData(SelectionKey selectionKey) {
        SocketChannel channel = null;
        try {
            channel = (SocketChannel) selectionKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int count = channel.read(byteBuffer);
            if (count > 0) {
                String msg = new String(byteBuffer.array());
                System.out.println("from 客户端：" + msg);
                sendInfoToOtherClients(msg, channel);
            }
        } catch (IOException e) {
            try {
                System.out.println(channel.getRemoteAddress() + "离线了");
                selectionKey.cancel();
                channel.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } finally {
        }
    }

    public void sendInfoToOtherClients(String msg, SocketChannel self) throws IOException {
        System.out.println("服务器转发消息中");
        for (SelectionKey key : selector.keys()) {
            Channel targetChannel = key.channel();
            if (targetChannel instanceof SocketChannel && targetChannel != self) {
                SocketChannel dest = (SocketChannel) targetChannel;
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
                dest.write(byteBuffer);
            }
        }
    }

    public static void main(String[] args) {
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }

}
