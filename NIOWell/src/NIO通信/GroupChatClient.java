package NIO通信;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author fangsheng
 * @date 2021/5/27 4:51 下午
 */
public class GroupChatClient {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 6666;
    private Selector selector;
    private SocketChannel socketChannel;
    private String userName;

    public GroupChatClient() throws IOException {
        selector = Selector.open();
        socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }
}
