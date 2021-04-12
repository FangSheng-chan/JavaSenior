package test4;

import java.util.Properties;

/**
 * @author fangsheng
 * @date 2021/3/30 下午3:01
 */
public class T8 {
    public static void main(String[] args) {
        byte a = 127;
        byte b = 127;
//        System.out.println(b = (byte) (a + b));
//        System.out.println(b = (byte) +a);

        float f = -343;
        long l = 012;
//        byte b2 = 128;
        byte b3 = 127;
        long d = 0X12345678;
        Properties properties = new Properties();

        String s = new String("abc");
        String s1 = s.intern();
        String s2 = "abc";
        System.out.println(s == s1);
        System.out.println(s1 == s2);
        System.out.println(s == s2);
    }
}
