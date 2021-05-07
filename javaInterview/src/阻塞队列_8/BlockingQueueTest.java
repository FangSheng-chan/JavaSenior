package 阻塞队列_8;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author fangsheng
 * @date 2021/5/7 10:09 上午
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(2);
        Producer producer1 = new Producer(blockingQueue);
//        Producer producer2 = new Producer(blockingQueue);
//        Producer producer3 = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(producer1);
//        executorService.execute(producer2);
//        executorService.execute(producer3);
        executorService.execute(consumer);
        Thread.sleep(10 * 1000);
        producer1.stop();
//        producer2.stop();
//        producer3.stop();
        Thread.sleep(2000);
        executorService.shutdown();
    }
}
