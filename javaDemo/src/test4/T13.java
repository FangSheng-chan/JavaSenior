package test4;

/**
 * @author fangsheng
 * @date 2021/4/4 上午12:51
 */
public class T13 {
    public static void main(String[] args) {
        String s1 = "ss";
        String s2 = new String("ss");
        System.out.println(s1 == s2);
        String s3 = s2.intern();
        System.out.println(s1 == s3);

    }
}
