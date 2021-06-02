package 排序.快速排序;

import org.junit.Test;

/**
 * @author fangsheng
 * @date 2021/6/1 10:12 上午
 */
public class T1 {

    /**
     * 值传递：调用函数时将实际参数复制一份传递到函数中，这样在函数中对参数进行修改，将不会影响到实际参数。传递对象往往为整数浮点型字符型等基本类型。
     *
     * @param args
     */
    public static void main(String[] args) {
        int x = 9;
        pass(x);
        System.out.println(x);
    }

    private static void pass(int y) {
        System.out.println(y);
        y = 0;
    }


    /**
     * 地址传递：调用函数时将实际参数的地址直接传递到函数中，那么在函数中对参数所进行的修改，将影响到实际参数。传递对象往往为数组等地址数据结构
     */
    @Test
    public void t1() {
        int[] x = {9};
        System.out.println(x[0]);
        PassByValueReference(x);
        System.out.println(x[0]);
    }

    public static void PassByValueReference(int[] y) {
        y[0] = 0;
    }

    @Test
    public void t2() {
        int x = 9;
        int y = 0;
        System.out.println(x);
        y = x;
        y = 10;
        System.out.println(x);
    }

    @Test
    public void t3() {
        int[] x = {1};
        System.out.println(x[0]);
        int[] y = x;
        y[0] = 0;
        System.out.println(x[0]);
    }
}
