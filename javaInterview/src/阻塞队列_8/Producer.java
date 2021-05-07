package 阻塞队列_8;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fangsheng
 * @date 2021/5/7 9:58 上午
 */
public class Producer implements Runnable {
    private volatile boolean isRunning = true;
    private BlockingQueue queue;
    private static AtomicInteger count = new AtomicInteger();
    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String data;
        while (isRunning) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(DEFAULT_RANGE_FOR_SLEEP));
                data = count.incrementAndGet() + "";
                System.out.println("将数据：" + data + "放入队列...");
                if (!queue.offer(data, 2L, TimeUnit.SECONDS)) {
                    System.out.println("放入数据失败" + data);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            } finally {
                System.out.println("退出生产者线程");
            }
        }
    }

    public void stop() {
        isRunning = false;
    }
}











