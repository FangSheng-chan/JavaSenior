package countDownLatch_CyclicBarrier_Semaphore使用_7;

import java.util.concurrent.CountDownLatch;

/**
 * ---> 做减法
 *
 * 让一些线程阻塞直到另一些线程完成一系列操作才被唤醒
 * CountDownLatch两个方法：当一个或多个线程调用await方法时，调用线程就会被阻塞。其他线程调用CountDown方法
 * 就会将计数器减1（调用CountDown方法的线程不会被阻塞），当计数器的值变成0时，因调用await方法被阻塞的线程会
 * 被唤醒，继续执行。
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 离开");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }



        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    System.out.println(Thread.currentThread().getName() + "\t 出走");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
//        try {
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName() + "\t ss关门");

    }
}
