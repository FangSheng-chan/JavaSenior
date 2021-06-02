package 排序.快速排序;

import java.util.Arrays;

/**
 * @author fangsheng
 * @date 2021/6/2 10:19 上午
 */
public class T2 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, 5};
        System.out.println(Arrays.toString(nums));
    }

    static int p(int[] nums, int lo, int hi) {
        int p = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (nums[++i] < p) {
                if (i == hi) {
                    break;
                }
            }
            while (nums[--j] > p) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, j, lo);
        return j;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
