package java并发实现原理.chapter06;

import java.text.SimpleDateFormat;
import java.util.concurrent.*;

/**
 * @author fangsheng
 * @date 2021/7/1 4:37 下午
 */
class MyThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            ScheduleThreadPoolExecutorDemo.formatCurrentTime();
            System.out.println("123");
        }
    }
}

/**
 * @author fangsheng
 * @date 2021/7/1 4:37 下午
 */
public class ScheduleThreadPoolExecutorDemo {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(myThread2);
//        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);
//        myScheduleWithFixedDelay(executor, myThread2, 2, 2, TimeUnit.SECONDS);
//        executor.scheduleAtFixedRate(myThread2, 2, 5, TimeUnit.SECONDS);
//        executor.scheduleWithFixedDelay(myThread2,2,5,TimeUnit.SECONDS);
    }

    /**
     * 延期执行
     *
     * @param executor
     * @param thread
     * @param delay
     * @param timeUnit
     */
    public static void mySchedule(ScheduledThreadPoolExecutor executor, Runnable thread, long delay, TimeUnit timeUnit) {
        executor.schedule(thread, delay, timeUnit);
        executor.shutdown();
    }

    /**
     * 周期执行任务
     *
     * @param executor
     * @param thread
     * @param delay
     * @param timeUnit
     */
    public static void myScheduleWithFixedDelay(ScheduledThreadPoolExecutor executor, Runnable thread, long initialDelay, long delay, TimeUnit timeUnit) {
        formatCurrentTime();
        System.out.println("123");
        executor.scheduleAtFixedRate(thread, initialDelay, delay, timeUnit);
    }

    public static void formatCurrentTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(System.currentTimeMillis());
        System.out.println(format);
    }
}
