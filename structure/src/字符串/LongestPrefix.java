package 字符串;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""
 * 思路很简单！先利用Arrays.sort(strs)为数组排序，再将数组第一个元素和最后一个元素的字符从前往后对比即可！
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * @author fangsheng
 * @date 2021/5/24 10:45 上午
 */
public class LongestPrefix {
    public static void main(String[] args) {
        String[] strs = {"cag", "dog", "car"};
        System.out.println("最长公共前缀：" + publicPrefix(strs));
    }

    public static String publicPrefix(String[] strings) {
        // 如果检查值不合法就返回字符串
        if (!checkStrings(strings)) {
            return "";
        }
        // 数组长度
        int length = strings.length;
        StringBuffer result = new StringBuffer();
        // 给字符串数组的元素按照升序排序(包含数字的话，数字会排在前面)
        Arrays.sort(strings);
        int m = strings[0].length();
        int n = strings[length - 1].length();
        int num = Math.min(m, n);
        for (int i = 0; i < num; i++) {
            if (strings[0].charAt(i) == strings[length - 1].charAt(i)) {
                result.append(strings[0].charAt(i));
            } else {
                break;
            }
        }
        return result.toString();
    }

    private static boolean checkStrings(String[] strings) {
        boolean flag = true;
        if (strings != null) {
            for (int i = 0; i < strings.length; i++) {
                if (strings[i] != null && strings[i].length() != 0) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return true;
    }
}
