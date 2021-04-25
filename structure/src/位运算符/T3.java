package 位运算符;

import java.util.HashMap;

/**
 * @author fangsheng
 * @date 2021/4/21 上午9:50
 */
public class T3 {
    public static void main(String[] args) {

    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int sum_i = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum_i += nums[i];
            int sum_j = sum_i - k;
            if (hashMap.containsKey(sum_j)) {
                ans += hashMap.get(sum_j);
            }
            hashMap.put(sum_i, hashMap.getOrDefault(sum_i, 0) + 1);
        }
        return ans;
    }
}
