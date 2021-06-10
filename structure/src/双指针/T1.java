package 双指针;

import java.util.Arrays;

/**
 * @author fangsheng
 * @date 2021/6/8 9:31 上午
 */
public class T1 {
    public static void main(String[] args) {
        int[] nums1 = {1, 4, 7, 0, 0, 0};
        int[] nums2 = {2, 3, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int sum = m + n - 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[sum--] = nums2[j--];
            } else if (j < 0) {
                nums1[sum--] = nums1[i--];
            } else if (nums1[i] > nums2[j]) {
                nums1[sum--] = nums1[i--];
            } else {
                nums1[sum--] = nums2[j--];
            }
        }
    }
}
