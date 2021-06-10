package java并发实现原理.chapter01;

/**
 * @author fangsheng
 * @date 2021/6/7 6:27 下午
 */
public class T10 extends Thread {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "start");
        for (int i = 0; i < 5; i++) {
            System.out.println(threadName + "loop at" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "start");
        T10 thread = new T10();
        try {
            thread.start();
            thread.join();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadName + "end");
    }
}
