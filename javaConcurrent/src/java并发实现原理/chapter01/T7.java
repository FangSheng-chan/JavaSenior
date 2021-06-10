package java并发实现原理.chapter01;

/**
 * @author fangsheng
 * @date 2021/6/4 1:56 下午
 */
public class T7 extends Thread {

    volatile boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            System.out.println("Thread is running...");
            long time = System.currentTimeMillis();
            while ((System.currentTimeMillis() - time < 1000)) {
            }
        }
        System.out.println("Thread exiting under request...");
    }

    public static void main(String[] args) throws InterruptedException {
        T7 thread = new T7();
        System.out.println("Starting thread....");
        thread.start();
        Thread.sleep(3000);
        System.out.println("Asking thread to stop");
        thread.stop = true;
    }
}
