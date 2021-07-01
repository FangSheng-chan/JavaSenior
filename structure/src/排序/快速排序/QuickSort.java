package 排序.快速排序;

import java.util.Arrays;

/**
 * @author fangsheng
 * @date 2021/5/31 10:25 上午
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] c = {35, 6, 57, 2, 98, 55, 34};
        quickSort(c, 0, c.length - 1);
//        sort(c);
        System.out.println(Arrays.toString(c));
    }

    static void quickSort(int[] s, int l, int r) {
        if (l < r) {
            int i = l, j = r, x = s[l];
            while (i < j) {
                // 从右向左找第一个小于x的数
                while (i < j && s[j] >= x) {
                    j--;
                }
                if (i < j) {
                    s[i] = s[j];
                    i++;
                }
                // 从左向右找第一个大于等于x的数
                while (i < j && s[i] < x) {
                    i++;
                }
                if (i < j) {
                    s[j] = s[i];
                    j--;
                }
            }
            s[i] = x;
            // 递归调用
            quickSort(s, l, i - 1);
            quickSort(s, i + 1, r);
        }
    }

    static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    /**
     * 快速选择算法
     *
     * @param nums
     * @param lo
     * @param hi
     */
    static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition(nums, lo, hi);
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    static int partition(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return lo;
        }
        //将nums[lo]作为默认分界点pivot
        int pivot = nums[lo];
        //j = hi +1 因为while 中 -- 会先执行
        int i = lo, j = hi + 1;
        while (true) {
            //保证nums[lo..i] 都小于pivot
            while (nums[++i] < pivot) {
                if (i == hi) {
                    break;
                }
            }
            //保证nums[j..hi]都大于pivot
            while (nums[--j] > pivot) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            //如果走到这里，一定有：nums[i] > pivot && nums[j] < pivot
            //所以需要交换 nums[i] 和 nums[j],保证nums[lo..j] < pivot < nums[j..hi]
            swap(nums, i, j);
        }
        // 将 pivot 值交换到正确的位置
        swap(nums, j, lo);
        // 现在 nums[lo..j-1] < nums[j] < nums[j+1..hi]
        return j;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
