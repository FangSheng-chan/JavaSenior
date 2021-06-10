package 高频面试系列;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author fangsheng
 * @date 2021/6/3 11:14 上午
 */
public class T2 {

    public static void main(String[] args) {
        Stack<Object> objects = new Stack<>();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 3, 4};
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}


