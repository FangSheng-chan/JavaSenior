import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.DatagramSessionConfig;
import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;
import org.apache.mina.transport.socket.nio.NioDatagramConnector;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @author fangsheng
 * @date 2021/5/18 10:54 上午
 */
public class MinaServer {

    private static final Logger logger = LoggerFactory.getLogger(MinaServer.class);

    public static void main(String[] args) {
        init();
    }

    public static void init() {
        NioDatagramAcceptor datagramAcceptor = new NioDatagramAcceptor();
        DatagramSessionConfig sessionConfig = datagramAcceptor.getSessionConfig();
        sessionConfig.setReadBufferSize(4096);
        datagramAcceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(
                new TextLineCodecFactory(Charset.forName("UTF-8"), LineDelimiter.WINDOWS.getValue(),
                        LineDelimiter.WINDOWS.getValue())));
        datagramAcceptor.setHandler(new ServerHandler());
        try {
            datagramAcceptor.bind(new InetSocketAddress(8866));
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("MinaServer 启动", "success" + 8866);
    }
}
