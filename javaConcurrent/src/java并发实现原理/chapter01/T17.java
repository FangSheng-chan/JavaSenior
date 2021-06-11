package java并发实现原理.chapter01;

/**
 * @author fangsheng
 * @date 2021/6/10 3:12 下午
 */
public class T17 {
    public static void main(String[] args) {

    }

    private int a = 0;
    private volatile int c = 0;

    public void set() {
        a = 5;
        c = 1;
    }

    public int get() {
        int d = c;
        return a;
    }
}
