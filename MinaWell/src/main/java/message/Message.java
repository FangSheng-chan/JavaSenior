package message;

/**
 * @author fangsheng
 * @date 2021/5/28 11:01 上午
 */
public class Message {
    public static class ReturnCode {

        public static String CODE_404 = "404";

        public static String CODE_403 = "403";

        public static String CODE_405 = "405";

        public static String CODE_200 = "200";

        public static String CODE_500 = "500";

    }

    public static final String SESSION_KEY = "account";

    /**
     * 服务端心跳请求命令
     */
    public static final String CMD_HEARTBEAT_REQUEST = "hb_request";

    /**
     * 客户端心跳相应命令
     */
    public static final String CMD_HEARTBEAT_RESPONSE = "hb_response";

    /**
     * 超时等待
     */
    public static final String TIME_OUT_NUM = "timeOutNum";

    public static class MessageType {
        //  用户踢出下线消息类型
        public static String TYPE_999 = "999";
    }

}
