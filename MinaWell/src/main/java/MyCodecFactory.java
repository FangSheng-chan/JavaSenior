import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * @author fangsheng
 * @date 2021/5/18 3:19 下午
 */
public class MyCodecFactory implements ProtocolCodecFactory {

    private final ProtocolEncoder encoder;

    private final ProtocolDecoder decoder;

    public MyCodecFactory(ProtocolEncoder encoder, ProtocolDecoder decoder) {
        this.encoder = encoder;
        this.decoder = decoder;
    }

    @Override
    public ProtocolEncoder getEncoder(IoSession session) throws Exception {
        return encoder;
    }

    @Override
    public ProtocolDecoder getDecoder(IoSession session) throws Exception {
        return decoder;
    }
}
