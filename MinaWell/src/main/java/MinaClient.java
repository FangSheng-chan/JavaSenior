import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.DatagramSessionConfig;
import org.apache.mina.transport.socket.nio.NioDatagramConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * @author fangsheng
 * @date 2021/5/18 4:16 下午
 */
public class MinaClient {

    public static void main(String[] args) {
        init();
    }

    public static void init() {
        NioDatagramConnector datagramConnector = new NioDatagramConnector(1);
        datagramConnector.setConnectTimeoutMillis(3000L);
        DatagramSessionConfig sessionConfig = datagramConnector.getSessionConfig();
        DefaultIoFilterChainBuilder filterChain = datagramConnector.getFilterChain();
        filterChain.addLast("codec", new ProtocolCodecFilter(
                new TextLineCodecFactory(Charset.forName("UTF-8"), LineDelimiter.WINDOWS.getValue(),
                        LineDelimiter.WINDOWS.getValue())));
        datagramConnector.setHandler(new ClientHandler());
        ConnectFuture connect = datagramConnector.connect(new InetSocketAddress("127.0.0.1", 8866));
        connect.awaitUninterruptibly();
        IoSession session = connect.getSession();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String msg = scanner.nextLine();
            session.write(msg + "\r\n");
        }
        session.getCloseFuture().awaitUninterruptibly();
        datagramConnector.dispose();
    }
}
