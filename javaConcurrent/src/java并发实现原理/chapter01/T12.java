package java并发实现原理.chapter01;

/**
 * @author fangsheng
 * @date 2021/6/8 2:47 下午
 */
public class T12 implements Runnable {

    private static int count;

    public T12() {
        count = 0;
    }

    static {

    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCount() {
        return count;
    }
}
