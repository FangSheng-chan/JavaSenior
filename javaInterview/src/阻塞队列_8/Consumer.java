package 阻塞队列_8;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author fangsheng
 * @date 2021/5/7 10:05 上午
 */
public class Consumer implements Runnable {
    private BlockingQueue<String> blockingQueue;
    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            try {
                String data = blockingQueue.poll(2, TimeUnit.SECONDS);
                if (null != data) {
                    System.out.println("正在消费数据：" + data);
                    Thread.sleep(ThreadLocalRandom.current().nextInt(DEFAULT_RANGE_FOR_SLEEP));
                } else {
                    isRunning = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            } finally {
                System.out.println("退出消费线程");
            }
        }
    }
}
