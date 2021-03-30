package s3;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 二分查找
 *
 * @author fangsheng
 * @date 2021/3/8 上午9:39
 */
public class Test01 {
    public static void main(String[] args) {
//        Random random = new Random();
//        double v = ThreadLocalRandom.current().nextDouble();

        int[] nums = {5, 7, 7, 8, 8, 10};

    }

    /**
     * 防止 int 溢出
     *
     * @param left
     * @param right
     * @return
     */
    static int binarySearch(int left, int right) {
        return left + (right - left) / 2;
    }

    static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (true) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {

            } else if (nums[mid] < target) {

            } else if (nums[mid] > target) {

            }
        }
    }

    /**
     * 寻找一个数（基本的二分搜索）
     *
     * @param nums
     * @param target
     * @return
     */
    static int binarySearchNums(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 闭区间 [left,right]
        // 这个区间其实就是每次进行搜索的区间。
        while (left <= right) {
            int mid = (right + left) / 2;
            // 什么时候应该停止搜索呢？当然，找到了目标值的时候可以终止
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }


    static int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }

        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    static int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    /**
     * 寻找左侧边界的二分搜索
     *
     * @param nums
     * @param target
     * @return
     */
    int left_bound2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        if (nums[left] != target || left >= nums.length){
            return -1;
        }
        return left;
    }
}


