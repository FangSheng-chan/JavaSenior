package nioDemo;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author fangsheng
 * @date 2021/5/26 4:28 下午
 */
public class T1 {

    public static void main(String[] args) {
        try {
            Server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        Selector selector = Selector.open();
        ServerSocket socket = serverSocketChannel.socket();
        socket.bind(new InetSocketAddress(6666));
        serverSocketChannel.configureBlocking(false);
        SelectionKey register = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println();
        while (true) {
            if (selector.select(1000) == 0) {
                System.out.println("服务器等待了1秒，无连接");
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            if (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功，生成一个SocketChannel：" + socketChannel.hashCode());
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    channel.read(buffer);
                    System.out.println("from 客户端：" + new String(buffer.array()));
                }
                keyIterator.remove();
            }
        }
    }

}























