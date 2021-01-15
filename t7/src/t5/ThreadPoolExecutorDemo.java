package t5;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 11, 1L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(20), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            MyRunnable worker = new MyRunnable("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
    }
}
