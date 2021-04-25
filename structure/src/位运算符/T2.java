package 位运算符;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author fangsheng
 * @date 2021/4/20 上午9:28
 */
public class T2 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 6};
        int[] b = {1, 1, 1, 5, 6};
        int[] c = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
//        System.out.println(subarraySum(b, 3));
//        sort(c);

        quick_sort(c, 0, c.length - 1);
        System.out.println(Arrays.toString(c));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySum2(int[] nums, int k) {
        int n = nums.length;
        //构造前缀和
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                //sum of nums[j .... i-1]
                if (sum[i] - sum[j] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }


    public static int subarraySum3(int[] nums, int k) {
        int n = nums.length;
        //map:前缀和 -》 该前缀和出现的次数
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int ans = 0, sum0_i = 0;
        for (int i = 0; i < n; i++) {
            sum0_i += nums[i];
            //这里我们找的前缀和 nums[0..j]
            int sum0_j = sum0_i - k;
            //如果前面有这个前缀和，直接更新答案
            if (preSum.containsKey(sum0_j)) {
                ans += preSum.get(sum0_j);
            }
            //把前缀和 nums[0..i]加入并记录出现次数
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return ans;
    }

    static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
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
        //j = hi +1 因为while 中会先执行
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

    static void quick_sort(int s[], int l, int r) {
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
            quick_sort(s, l, i - 1);
            quick_sort(s, i + 1, r);
        }
    }
}











