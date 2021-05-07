package 线程池_10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fangsheng
 * @date 2021/5/6 2:40 下午
 */

/**
 * (辅助工具类）
 * Array Arrays
 * Collection Collections
 * Executor Executors
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            for (int i = 0; i < 10; i++) {
                int finalI = i;
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + finalI);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
