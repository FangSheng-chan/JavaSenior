package 双指针.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangsheng
 * @date 2021/6/11 9:47 上午
 */
public class T2 {

    public static void main(String[] args) {
        boolean b = checkInclusion("abbc", "ca");
        System.out.println(b);
    }

    public String minWin(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        int t_len = t.length();
        for (int i = 0; i < t_len; i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                Integer tmp = window.getOrDefault(c, 0);
                window.put(c, ++tmp);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                start = left;
                len = right - left;
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    int tmp = window.get(d);
                    window.put(d, --tmp);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;
        int t_len = s1.length();
        for (int i = 0; i < t_len; i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                Integer temp = window.getOrDefault(c, 0);
                window.put(c, ++temp);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (right - left >= t_len) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    Integer temp = window.get(d);
                    window.put(d, --temp);
                }
            }
        }
        return false;
    }
}
