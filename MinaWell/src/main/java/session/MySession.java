package session;

import org.apache.mina.core.session.IoSession;
import protocol.CustomPack;

import java.io.Serializable;
import java.net.SocketAddress;

/**
 * IoSession包装类
 *
 * @author fangsheng
 * @date 2021/5/28 1:55 下午
 */
public class MySession implements Serializable {
    private static final long serialVersionUID = 7009939771354948475L;
    private transient IoSession session;
    private String gid;
    /**
     * session在本机器中的id
     */
    private Long nid;
    private String host;
    private String account;
    private String message;
    private String scanNum;
    private String longitude;
    private String latitude;
    private Long bindTime;
    private Long heartbeat;

    public MySession() {
    }

    public MySession(IoSession session) {
        this.session = session;
        this.host = (String) session.getAttribute("address");
        this.nid = session.getId();
    }

    public void setAttribute(String key, Object value) {
        if (sessionIsNull()) {
            session.setAttribute(key, value);
        }
    }

    public void getAttribute(String key) {
        if (sessionIsNull()) {
            session.getAttribute(key);
        }
    }

    public boolean containsAttribute(String key) {
        if (sessionIsNull()) {
            return session.containsAttribute(key);
        } else {
            return false;
        }
    }

    public void removeAttribute(String key) {
        if (sessionIsNull()) {
            session.removeAttribute(key);
        }
    }

    public SocketAddress getRemoteAddress() {
        if (sessionIsNull()) {
            return session.getRemoteAddress();
        } else {
            return null;
        }
    }

    public void write(Object msg) {
        if (sessionIsNull()) {
            new CustomPack()
        }
    }

    public boolean sessionIsNull() {
        return (null != session);
    }

}














