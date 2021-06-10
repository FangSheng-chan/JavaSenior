package java并发实现原理.chapter01;

/**
 * @author fangsheng
 * @date 2021/6/4 2:23 下午
 */
public class T9 extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Thread running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Thread interrupted...");
                System.out.println(this.isInterrupted());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Thread exiting under request...");
    }

    public static void main(String[] args) throws Exception {
        T9 thread = new T9();
        System.out.println("Starting thread...");
        thread.start();
        Thread.sleep(3000);
        System.out.println("Asking thread to stop...");
        thread.interrupt();
        Thread.sleep(3000);
        System.out.println("Stopping application...");
    }
}
