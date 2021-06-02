package 字符串;

/**
 * 剑指offer: 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * https://www.weiweiblog.cn/strtoint/
 *
 * @author fangsheng
 * @date 2021/5/31 11:19 上午
 */
public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(strToInt("123"));
    }

    public static int strToInt(String str) {
        if (str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int flag = 0;
        if (chars[0] == '+') {
            flag = 1;
        } else if (chars[0] == '-') {
            flag = 2;
        }
        int start = flag > 0 ? 1 : 0;
        int res = 0;
        for (int i = start; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                int temp = chars[i] - '0';
                res = res * 10 + temp;
            } else {
                return 0;
            }
        }
        return flag != 2 ? res : -res;
    }
}
