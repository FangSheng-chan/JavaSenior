package java并发实现原理.chapter01;

/**
 * @author fangsheng
 * @date 2021/6/7 6:49 下午
 */
public class WaitNotifyTest {
    public static void main(String[] args) {
        Object lock = new Object();

        new Thread(() -> {
            System.out.println("线程A等待获取🔒");
            synchronized (lock) {
                System.out.println("线程A获取了lock🔒");
                try {
                    Thread.sleep(1000);
                    System.out.println("线程A将要运行lock.wait()方法进行等待");
                    lock.wait();
                    System.out.println("线程A等待结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            System.out.println("线程B等待获取🔒");
            synchronized (lock) {
                System.out.println("线程B获取了lock🔒");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程B将要运行lock.notify()方法进行通知");
                lock.notify();
            }
        }).start();
    }
}
