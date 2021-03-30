package s4;

import java.util.HashMap;

/**
 * @author fangsheng
 * @date 2021/3/22 上午9:57
 */
public class ArrayTest {
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    static void moveZeroes(int[] nums) {
        int p = removeElement(nums, 0);
        while (p < nums.length) {
            nums[p] = 0;
            p++;
        }
//        for (; p < nums.length; p++) {
//            nums[p] = 0;
//        }
    }

    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    static int[] twoSum2(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            int other = target - nums[i];
            if (map.containsKey(other) && map.get(other) != i) {
                return new int[]{i, map.get(other)};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {23, 55, 67, 13, 12};
        int[] ints = twoSum2(nums, 80);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

class TwoSum {

    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public void add(int number) {
        hashMap.put(number, hashMap.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (Integer key : hashMap.keySet()) {
            int other = value - key;
            if (other == key && hashMap.get(key) > 1){
                return true;
            }
        }
        return false;
    }
}