package 双指针.左右指针;

import java.util.Arrays;

/**
 * 解决数组（或者字符串）中的问题，比如二分查找
 * 只要数组有序，就应该想到双指针技巧。
 * 左右指针在数组中实际是指两个索引值，一般初始化为left = 0,right = nums.length-1
 *
 * @author fangsheng
 * @date 2021/5/27 10:59 上午
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4};
        String s = "hello3";
        char[] chars = s.toCharArray();
        reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }

    static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
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

    static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            if (target - numbers[left] == numbers[right]) {
                return new int[]{left + 1, right + 1};
            } else if (target - numbers[left] < numbers[right]) {
                right--;
            } else if (target - numbers[left] > numbers[right]) {
                left++;
            }
        }
        return new int[]{};
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}











