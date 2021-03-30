package test2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangsheng
 * @date 2021/3/5 下午4:25
 */
public class T5 {
    public static void main(String[] args) {
        try {
            ss();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ss();
    }


    public static void ss() {
        throw new RuntimeException("调用异常方法");
    }
}

//public class WangException extends RuntimeException {
//    /**
//     * 错误码
//     */
//    private WangErrorCodeEnum errorCode;
//    /**
//     * 详细错误信息
//     */
//    private Map errorMap = new HashMap();
//
//    /**
//     * 带参构造器. * @  errorCode
//     */
//    public WangException(WangErrorCodeEnum errorCode) {
//        super(errorCode.getDesc());
//        this.setErrorCode(errorCode);
//    }
//
//    /**
//     * 带参构造器
//     */
//    public WangException(WangErrorCodeEnum errorCode, String message) {
//        super(StringUtils.isNotBlank(message) ? message : errorCode.getDesc());
//        this.setErrorCode(errorCode);
//    }
//
//    /**
//     * 带参构造器. * @param errorCode * @param errorContext
//     */
//    public WangException(WangErrorCodeEnum errorCode, ErrorContext errorContext) {
//        this(errorCode, findMessage(errorContext));
//    }
//
//    /**
//     * 带参构造器. * @param errorCode * @param errorMap
//     */
//    public WangException(WangErrorCodeEnum errorCode, Map errorMap) {
//        this(errorCode);
//        this.errorMap = errorMap;
//    }
//
//    /**
//     * 带参构造器. * @param errorCode * @param message
//     */
//    public WangException(WangErrorCodeEnum errorCode, String message, Map errorMap) {
//        super(StringUtils.isNotBlank(message) ? message : errorCode.getDesc());
//        this.setErrorCode(errorCode);
//        this.errorMap = errorMap;
//    }
//
//    /**
//     * 带参构造器. * * @param message
//     */
//    public WangException(String message) {
//        super(message);
//        this.setErrorCode(WangErrorCodeEnum.UNKNOWN_SYS_ERROR);
//    }
//}


enum WangErrorCodeEnum {
    SYS_ERROR("SYS_ERROR");

    WangErrorCodeEnum(String sys_error) {

    }


}

