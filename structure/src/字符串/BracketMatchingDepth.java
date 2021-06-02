package 字符串;


/**
 * @author fangsheng
 * @date 2021/5/31 11:10 上午
 */
public class BracketMatchingDepth {
    public static void main(String[] args) {
        String s = "(())((()))";
        int count = 0, max = 0, i;
        for (i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
