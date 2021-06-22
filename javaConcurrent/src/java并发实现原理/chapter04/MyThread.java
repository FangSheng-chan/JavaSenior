package java并发实现原理.chapter04;

import java.util.concurrent.Phaser;

/**
 * @author fangsheng
 * @date 2021/6/21 3:20 下午
 */
public class MyThread extends Thread {

    public Phaser phaser;

    public MyThread(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println("线程" + Thread.currentThread().getName() + "到达屏障开始等待时间：" + System.currentTimeMillis());
        phaser.arriveAndAwaitAdvance();
        System.out.println("线程" + Thread.currentThread().getName() + "通过屏障时间：" + System.currentTimeMillis());
    }
}
