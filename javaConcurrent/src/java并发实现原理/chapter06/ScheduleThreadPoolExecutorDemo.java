package java并发实现原理.chapter06;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fangsheng
 * @date 2021/7/1 4:37 下午
 */
class MyThread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("123");
    }
}
/**
 * @author fangsheng
 * @date 2021/7/1 4:37 下午
 */
public class ScheduleThreadPoolExecutorDemo {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);
//        executor.scheduleAtFixedRate(myThread2, 2, 5, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(myThread2,2,5,TimeUnit.SECONDS);
    }
}
