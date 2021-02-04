package struct01;

import java.net.SocketAddress;

/**
 * @author fangsheng
 * @date 2021/1/29 上午9:56
 */
public class Demo03 {

    static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
