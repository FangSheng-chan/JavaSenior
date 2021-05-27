package 排序.归并排序;

/**
 * @author fangsheng
 * @date 2021/5/27 9:35 上午
 */

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9, 4, 3, 2, 1, 6, 5, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(arr, left, middle, temp);
            sort(arr, middle + 1, right, temp);
            merge(arr, left, middle, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int middle, int right, int[] temp) {
        int i = left;
        int j = middle + 1;
        int t = 0;
        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= middle) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

}