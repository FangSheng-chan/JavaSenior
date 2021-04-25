package test5;

/**
 * @author fangsheng
 * @date 2021/4/21 下午4:55
 */
public class T2 {
    public static void main(String[] args) {
        char[] chars = "Hello".toCharArray();
        String s = new String(chars);
        System.out.println(s);
        chars[0] = 'X';
        for (char c : chars) {
            System.out.println(c);
        }
        System.out.println(s);
    }
}
