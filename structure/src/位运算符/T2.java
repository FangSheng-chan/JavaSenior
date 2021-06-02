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
        int[] b = {-1, 0, 3, 5, 9, 12};
        int[] c = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
        System.out.println(Arrays.toString(c));
        int result = binarySearch(b, 3);
        int result2 = recursionBinarySearch(b, 12, 0, b.length - 1);
        System.out.println(result);
        System.out.println(result2);
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



    public static int search(int[] nums, int target) {
        return recursionBinarySearch(nums,target,0,nums.length-1);
    }

    static int recursionBinarySearch(int[] arr, int key, int l, int r) {
        if (key < arr[l] || key > arr[r] || l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (arr[mid] > key) {
            return recursionBinarySearch(arr, key, l, mid - 1);
        } else if (arr[mid] < key) {
            return recursionBinarySearch(arr, key, mid + 1, r);
        } else {
            return mid;
        }
    }

    static int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            }
        }
        return -1;
    }
}











