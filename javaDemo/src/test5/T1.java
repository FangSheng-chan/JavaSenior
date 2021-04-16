package test5;

import java.util.Arrays;

/**
 * @author fangsheng
 * @date 2021/4/13 下午2:31
 */
public class T1 {
    public static void main(String[] args) {
        int[] ints = new int[10];
        String[] strings1 = {"1", "2"};
        Integer[] Integer1 = {1, 2};
        String[] strings2 = {"1", "2"};
        Integer[] Integer2 = {1, 2};
        System.out.println(strings1.equals(strings2));
        System.out.println(ints.length);
        System.out.println(Arrays.equals(strings1, strings2));
        boolean equals = Arrays.equals(Integer1, Integer2);
        System.out.println(equals);
    }
}
