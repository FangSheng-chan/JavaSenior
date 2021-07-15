package Java多线程基础.test.countDownLatchDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @author fangsheng
 * @date 2021/7/11 6:52 下午
 */
public class TestWork2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Worker2 worker0 = new Worker2("worker0", (long) (Math.random() * 2000 + 3000), countDownLatch);
        Worker2 worker1 = new Worker2("worker1", (long) (Math.random() * 2000 + 3000), countDownLatch);
        Worker2 worker2 = new Worker2("worker2", (long) (Math.random() * 2000 + 3000), countDownLatch);
        worker0.start();
        worker1.start();
        countDownLatch.await();
        System.out.println("准备工作就绪");
        worker2.start();
    }
}
