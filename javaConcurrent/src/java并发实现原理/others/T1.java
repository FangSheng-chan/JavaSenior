package java并发实现原理.others;

import java.util.concurrent.CountDownLatch;

/**
 * @author fangsheng
 * @date 2021/7/8 2:13 下午
 */
public class T1 {
    private int i = 0;
    private final CountDownLatch mainLatch = new CountDownLatch(1);

    public  void add() {
        i++;
    }

    private class Work extends Thread {
        private CountDownLatch threadLatch;

        public Work(CountDownLatch latch) {
            threadLatch = latch;
        }

        @Override
        public void run() {
            try {
                mainLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < 10000; j++) {
                add();
            }
            threadLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int k = 0; k < 10; k++) {
            T1 test = new T1();
            CountDownLatch threadLatch = new CountDownLatch(10);
            for (int i = 0; i < 10; i++) {
                test.new Work(threadLatch).start();
            }
            test.mainLatch.countDown();
            threadLatch.await();
            System.out.println(test.i);
        }
    }

}
