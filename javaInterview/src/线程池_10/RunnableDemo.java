package 线程池_10;

import java.util.concurrent.TimeUnit;

/**
 * @author fangsheng
 * @date 2021/5/6 2:32 下午
 */

class MyThread2 implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + "\trunnable");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread2(), "AAA");
        thread.start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        }).start();
    }
}
