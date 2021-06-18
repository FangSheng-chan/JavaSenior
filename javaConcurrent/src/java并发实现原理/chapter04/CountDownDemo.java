package java并发实现原理.chapter04;

import java.util.concurrent.CountDownLatch;

/**
 * @author fangsheng
 * @date 2021/6/18 4:36 下午
 */
public class CountDownDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        countDownLatch.await();
        countDownLatch.countDown();

    }
}
