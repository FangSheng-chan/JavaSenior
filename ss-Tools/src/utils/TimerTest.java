package utils;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fangsheng
 * @date 2021/5/20 9:41 上午
 */
public class TimerTest {
    public static void main(String[] args) {
        /**
         * 优点：基于多线程的定时任务，多个任务之间不会相关影响，支持周期性的执行任务，并且带延迟功能。
         * 缺点：不支持一些较复杂的定时规则。
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("do something");
        }, 3, 1, TimeUnit.SECONDS);
    }
}
