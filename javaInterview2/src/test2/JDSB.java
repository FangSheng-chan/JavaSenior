package test2;

/**
 * @author fangsheng
 * @date 2021/2/25 下午6:02
 */
public class JDSB {

    public final static Object object = new Object();

    public static int count = 0;

    public static synchronized void sayA() {
        System.out.println("我是线程:" + Thread.currentThread().getName() + "我开始执行sayA");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是线程:" + Thread.currentThread().getName() + "我离开sayA");
    }

    public void add() {
        synchronized (this) {
            count += 1;
        }
    }

    public void dec() {
        synchronized (this) {
            count -= 1;
        }
    }

    public int get() {
        return count;
    }
}
