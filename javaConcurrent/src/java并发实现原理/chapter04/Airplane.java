package java并发实现原理.chapter04;

import java.util.Random;
import java.util.concurrent.Phaser;

/**
 * @author fangsheng
 * @date 2021/6/21 11:32 上午
 */
public class Airplane {
    private Phaser phaser;
    private Random random;

    public Airplane(int peopleNum) {
        phaser = new Phaser(peopleNum);
        random = new Random();
    }

    public void getOffPlane() {
        try {
            String name = Thread.currentThread().getName();
            Thread.sleep(random.nextInt(500));
            System.out.println(name + " 在飞机在休息着....");
            Thread.sleep(random.nextInt(500));
            System.out.println(name + " 下飞机了");
            phaser.arrive();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doWork(){
        String name = Thread.currentThread().getName();
        System.out.println(name + "准备做 清理 工作");
        phaser.awaitAdvance(phaser.getPhase());
        System.out.println("飞机的乘客都下机," + name + "可以开始做 清理 工作");

    }
}
