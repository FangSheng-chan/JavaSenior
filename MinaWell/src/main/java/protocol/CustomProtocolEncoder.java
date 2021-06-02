package protocol;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.nio.charset.Charset;

/**
 * @author fangsheng
 * @date 2021/5/28 2:54 下午
 */
public class CustomProtocolEncoder extends ProtocolEncoderAdapter {

    private final Charset charset;

    public CustomProtocolEncoder() {
        this.charset = Charset.defaultCharset();
    }

    public CustomProtocolEncoder(Charset charset) {
        this.charset = charset;
    }

    @Override
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {

    }
}
