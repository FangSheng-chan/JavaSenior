package java并发实现原理.chapter04;

import java.util.concurrent.Phaser;

/**
 * @author fangsheng
 * @date 2021/6/21 11:08 上午
 */
public class PhaserDemo {
    public static void main(String[] args) throws InterruptedException {
        testPhaseCyclicBarrier();
    }

    private static void testPhaseCyclicBarrier2() throws InterruptedException {
        Phaser phaser = new Phaser(2);

        MyThread threadA = new MyThread(phaser);
        threadA.setName("A");
        threadA.start();
        Thread.sleep(2000);

        MyThread threadB = new MyThread(phaser);
        threadB.setName("B");
        threadB.start();
        Thread.sleep(2000);

        MyThread threadC = new MyThread(phaser);
        threadC.setName("C");
        threadC.start();
        Thread.sleep(2000);

        MyThread threadD = new MyThread(phaser);
        threadD.setName("D");
        threadD.start();
        Thread.sleep(2000);

        MyThread threadE = new MyThread(phaser);
        threadE.setName("E");
        threadE.start();
    }

    private static void testPhaseCyclicBarrier() {
        Phaser phaser = new Phaser(6);
        for (int i = 0; i < 5; i++) {
            int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 收集到 第" + tempInt + "颗龙珠");
                phaser.arriveAndAwaitAdvance();
            }).start();
        }
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + "\t召唤神龙");
    }

    private static void testPhaseCountDownLatch() {
        Phaser phaser = new Phaser(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 离开");
                phaser.arrive();
            }).start();
        }
        phaser.awaitAdvance(phaser.getPhase());
        System.out.println(Thread.currentThread().getName() + "\t 离开");
    }
}
