package Java多线程基础.test.countDownLatchDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @author fangsheng
 * @date 2021/7/11 6:47 下午
 */
public class Worker2 extends Thread {

    private String name;

    private long time;

    private CountDownLatch countDownLatch;

    public Worker2(String name, long time, CountDownLatch countDownLatch) {
        this.name = name;
        this.time = time;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + "开始工作");
            Thread.sleep(time);
            System.out.println(name + "第一阶段工作完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
            System.out.println("countDownLatch=\t" + countDownLatch.getCount());
        }
        try {
            Thread.sleep(2000);
            System.out.println(name + "第二阶段工作完成");
            System.out.println(name + "工作完成，耗费时间=" + (time + 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
