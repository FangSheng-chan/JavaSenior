package test4;

import java.util.Properties;

/**
 * @author fangsheng
 * @date 2021/3/30 下午3:01
 */
public class T8 {
    public static void main(String[] args) {
        String s = new String("abc");
        String s2 = "abc";
        String s1 = s.intern();
        System.out.println(s == s1);
        System.out.println(s1 == s2);
        System.out.println(s == s2);
    }
}
