package java并发实现原理.chapter01;

/**
 * @author fangsheng
 * @date 2021/6/10 3:33 下午
 */
public class T18 {
    private final int i;
    private final int j;
    private static T18 obj;

    public T18() {
        i = 1;
        j = 2;
    }

    public static void write() {
        obj = new T18();
    }

    public static void read() {
        if (obj != null) {
            int a = obj.i;
            int b = obj.j;
        }
    }
}
