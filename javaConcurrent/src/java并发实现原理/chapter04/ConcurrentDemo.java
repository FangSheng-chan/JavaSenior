package java并发实现原理.chapter04;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;

/**
 * @author fangsheng
 * @date 2021/6/21 3:35 下午
 */
public class ConcurrentDemo {
    public static void main(String[] args) {
        test3();
    }

    public static void test1() {
        /**
         * CountDownLatch不可以循环使用
         */
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(new Double(Math.random() * 3000).longValue());
                    System.out.println(Thread.currentThread().getName() + "玩家准备就绪");
                    countDownLatch.countDown();
                    System.out.println("选英雄");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("游戏开始");
    }

    public static void test2() {
        /**
         * CyclicBarrier可以循环使用的
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(new Double(Math.random() * 3000).longValue());
                    System.out.println(Thread.currentThread().getName() + "玩家准备就绪");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "就绪完毕，开始选择英雄");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void test3() {
        Phaser phaser = new Phaser(5);
        getInfo(phaser);
    }

    public static void test4() {
        Phaser phaser = new Phaser(1);
    }

    private static void getInfo(Phaser phaser) {
        System.out.println("阶段：" + phaser.getPhase());
        System.out.println("到达数：" + phaser.getArrivedParties());
        System.out.println("未到达数：" + phaser.getUnarrivedParties());
        System.out.println("总数：" + phaser.getRegisteredParties());
    }
}
