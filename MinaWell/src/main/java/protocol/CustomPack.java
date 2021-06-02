package protocol;

/**
 * 自定义协议包
 * 协议为：数据长度（4个字节）+协议编号（1字节）+真实数据
 *
 * @author fangsheng
 * @date 2021/5/28 2:43 下午
 */
public class CustomPack {
    public static final byte REQUEST = 0 * 00;
    public static final byte RESPONSE = 0 * 01;
    /**
     * 总长度（编号字节+长度字节+包体长度字节）
     */
    private int len;
    /**
     * 版本号
     */
    private byte flag;
    /**
     * 包体
     */
    private String content;

    public CustomPack() {
    }

    public CustomPack(String content) {
        this.content = content;
    }

    public CustomPack(byte flag, String content) {
        this.flag = flag;
        this.content = content;
        this.len = 1 + 4 + (content == null ? 0 : content.getBytes().length);
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte getFlag() {
        return flag;
    }

    public void setFlag(byte flag) {
        this.flag = flag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CustomPack{" +
                "len=" + len +
                ", flag=" + flag +
                ", content='" + content + '\'' +
                '}';
    }
}
