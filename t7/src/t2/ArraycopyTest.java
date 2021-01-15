package t2;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraycopyTest {
    public static void main(String[] args) {
        int[] a = new int[3];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        int[] b = Arrays.copyOf(a, 10);
        System.out.println(b.length);
    }
}
