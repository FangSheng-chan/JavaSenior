package java并发实现原理.chapter06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fangsheng
 * @date 2021/7/6 2:46 下午
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newScheduledThreadPool(2);
        try {
            for (int i = 0; i < 10; i++) {
                final int tempInt = i;
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 用户：" + tempInt + "办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
