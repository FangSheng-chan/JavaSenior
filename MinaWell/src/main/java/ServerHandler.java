import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.FilterEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author fangsheng
 * @date 2021/5/18 10:57 上午
 */
public class ServerHandler extends IoHandlerAdapter {

    public ServerHandler() {
        super();
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerHandler.class);

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        LOGGER.info("session create");
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {

    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        LOGGER.info("session closed");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {

    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {

    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        LOGGER.info(message.toString().trim());
        if (message.equals("exit")) {
            session.closeNow();
        }
        Date date = new Date();
        session.write(date);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {

    }

    @Override
    public void inputClosed(IoSession session) throws Exception {

    }

    @Override
    public void event(IoSession session, FilterEvent event) throws Exception {

    }
}
