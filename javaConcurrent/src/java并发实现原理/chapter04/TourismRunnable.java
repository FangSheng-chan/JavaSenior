package java并发实现原理.chapter04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fangsheng
 * @date 2021/6/21 11:21 上午
 */
public class TourismRunnable implements Runnable {

    Phaser phaser;
    Random random;

    AtomicInteger friendCount = new AtomicInteger();

    public TourismRunnable(Phaser phaser) {
        this.phaser = phaser;
        random = new Random();
    }

    @Override
    public void run() {
        switch (phaser.getPhase()) {
            case 0:
                if (!goToStartingPoint()) {
                    break;
                }
            case 1:
                if (!goToHotel()) {
                    break;
                }
            case 2:
                if (!goToTourismPoint1()) {
                    break;
                }
        }
    }

    private void tourism() {
        goToStartingPoint();
        goToHotel();
        goToTourismPoint1();
    }

    private boolean goToTourismPoint1() {
        return goToPoint("旅游点1");
    }

    private boolean goToHotel() {
        return goToPoint("酒店");
    }

    private boolean goToStartingPoint() {
        return goToPoint("出发点");
    }

    private int getRandomTime() throws InterruptedException {
        int time = random.nextInt(400) + 100;
        Thread.sleep(time);
        return time;
    }

    private boolean goToPoint(String point) {
        try {
            if (!randomEvent()) {
                phaser.arriveAndDeregister();
                return false;
            }
            String name = Thread.currentThread().getName();
            System.out.println(name + " 花了 " + getRandomTime() + " 时间才到了" + point);
            phaser.arriveAndAwaitAdvance();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean randomEvent() {
        int r = random.nextInt();
        String name = Thread.currentThread().getName();
        if (r < 10) {
            int friendNum = 1;
            System.out.println(name + ":在这里竟然遇到了" + friendNum + "个朋友,他们说要一起去旅游...");
            phaser.bulkRegister(friendNum);
            for (int i = 0; i < friendNum; i++) {
                new Thread(new TourismRunnable(phaser), name + "的朋友" + friendCount.getAndAdd(1) + "号").start();
            }
        } else if (r > 90) {
            System.out.println(name + ":突然有事要离开一下,不和他们继续旅游了....");
            return false;
        }
        return true;
    }
}
