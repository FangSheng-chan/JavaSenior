package test4;

import java.util.HashMap;

/**
 * @author fangsheng
 * @date 2021/4/1 下午4:35
 */
public class T10 {
    public static void main(String[] args) throws Exception {
//        Object x = new Integer(0);
//        System.out.println((String)x);
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("",123);
        System.out.println(hashMap.size());
    }

    private static void throwException() throws Exception {
        throw new Exception("Exception");
    }

    private static void throwRuntimeException() {
        throw new RuntimeException("RunTimeException");
    }
}
