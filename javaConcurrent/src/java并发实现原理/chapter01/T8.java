package java并发实现原理.chapter01;

/**
 * @author fangsheng
 * @date 2021/6/4 2:19 下午
 */
public class T8 extends Thread {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("thread is running...");
            long time = System.currentTimeMillis();
            while ((System.currentTimeMillis() - time < 1000)) {
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T8 thread = new T8();
        thread.start();
        Thread.sleep(3000);
        System.out.println("Asking thread to stop...");
        // 发出中断请求
        thread.interrupt();
        Thread.sleep(3000);
        System.out.println("Stopping application...");
    }
}
