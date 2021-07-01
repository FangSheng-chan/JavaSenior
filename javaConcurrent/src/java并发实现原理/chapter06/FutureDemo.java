package java并发实现原理.chapter06;

import java.util.concurrent.*;

/**
 * @author fangsheng
 * @date 2021/6/29 4:51 下午
 */
public class FutureDemo {
    public static void main(String[] args) {
        Callable<String> myCallable = new MyCallable();
        BlockingQueue blockingQueue = new ArrayBlockingQueue<String>(10);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 3, TimeUnit.SECONDS, blockingQueue);
        Future<String> future = executor.submit(myCallable);
        try {
            String s = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
