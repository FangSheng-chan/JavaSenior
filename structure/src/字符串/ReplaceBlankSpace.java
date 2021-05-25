package 字符串;

/**
 * 替换空格
 * 剑指offer：请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author fangsheng
 * @date 2021/5/24 10:22 上午
 */
public class ReplaceBlankSpace {
    public static void main(String[] args) {
        String s = replaceSpace2(new StringBuffer("We Are Happy"));
        System.out.println(s);
    }

    public static String replaceSpace(StringBuffer str) {
        int length = str.length();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (String.valueOf(c).equals(" ")) {
                result.append("%20");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String replaceSpace2(StringBuffer str) {
        return str.toString().replaceAll("\\s", "%20");
    }
}
