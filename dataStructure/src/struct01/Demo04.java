package struct01;

import java.util.Arrays;

/**
 * @author fangsheng
 * @date 2021/2/3 下午3:49
 */
public class Demo04 {
    public static void main(String[] args) {
        int i = 0;
        int j = 4;
        int a[] = {1, 2, 3, 4, 5};

        a[++i] = a[j];
        System.out.println(Arrays.toString(a));
        j--;
        a[i++] = a[j];
        System.out.println(Arrays.toString(a));
    }
}
