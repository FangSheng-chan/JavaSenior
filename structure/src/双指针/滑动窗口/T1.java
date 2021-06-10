package 双指针.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口实际上是通过双指针来实现的，[left,right]之间的范围就是窗口。通常用于解决字符串、数组相关的问题。比如最小子串
 *
 * @author fangsheng
 * @date 2021/6/8 10:38 上午
 */
public class T1 {

    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.getOrDefault("1", 0);
        System.out.println(minWindow("EBBANCF", "ABC"));
    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int t_len = t.length();
        for (int i = 0; i < t_len; i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及⻓度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            // 右移窗口
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                int tmp = window.getOrDefault(c, 0);
                window.put(c, ++tmp);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                // len用于记录当前最佳的长度
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    int tmp = window.get(d);
                    window.put(d, --tmp);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static boolean checkInclusion(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int t_len = t.length();
        for (int i = 0; i < t_len; i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及⻓度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            // 右移窗口
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                int tmp = window.getOrDefault(c, 0);
                window.put(c, ++tmp);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= t_len) {
                // 在这里更新最小覆盖子串
                if (valid == need.size()) {
                    return true;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    int tmp = window.get(d);
                    window.put(d, --tmp);
                }
            }
        }
        // 返回最小覆盖子串
        return false;
    }
}
