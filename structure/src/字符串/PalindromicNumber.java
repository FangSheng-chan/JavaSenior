package 字符串;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author fangsheng
 * @date 2021/5/25 10:47 上午
 */
public class PalindromicNumber {
    public static void main(String[] args) {
        longestPalindrome("abcccdd");
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(longestPalindrome2("babad"));
    }

    /**
     * 最长回文串
     *
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        //用于存放字符
        HashSet<Character> hashSet = new HashSet<>();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!hashSet.contains(chars[i])) {
                hashSet.add(chars[i]);
            } else {
                hashSet.remove(chars[i]);
                count++;
            }
        }
        return hashSet.isEmpty() ? count * 2 : count * 2 + 1;
    }

    /**
     * 验证回文串
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } else {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                } else {
                    l++;
                    r--;
                }
            }
        }
        return true;
    }

    private static int index, len;

    /**
     * 最长回文子串
     *
     * @param s
     * @return
     */
    public static String longestChildPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            PalindromeHelper(s, i, i);
            PalindromeHelper(s, i, i + 1);
        }
        return s.substring(index, index + len);
    }

    public static void PalindromeHelper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (len < r - l - 1) {
            index = l + 1;
            len = r - l - 1;
        }
    }



    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
