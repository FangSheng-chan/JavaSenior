package java并发编程之美.chapter1;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * @author fangsheng
 * @date 2021/5/29 5:38 下午
 */
public class T2 {
    public static void main(String[] args) {
        int maxValue = Integer.MAX_VALUE;
        BlockingQueue<Object> queue = new ArrayBlockingQueue(2);
        synchronized (queue) {
            while (queue.size() == maxValue) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void t1() {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(10);
        Executors.newFixedThreadPool(3);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 30, 2, TimeUnit.SECONDS, workQueue);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);
//        threadPoolExecutor.submit();
    }
}
