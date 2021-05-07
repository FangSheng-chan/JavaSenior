package 线程池_10;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fangsheng
 * @date 2021/5/6 4:27 下午
 */
public class SheduledThreadPoolExecutorTest {

    public void timerExcute() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);

        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            System.out.println("执行操作：时间为：" + new Date());
        }, 2, 3, TimeUnit.SECONDS);
    }


    public static void main(String[] args) {
        SheduledThreadPoolExecutorTest sheduledThreadPoolExecutorTest = new SheduledThreadPoolExecutorTest();
        sheduledThreadPoolExecutorTest.timerExcute();
    }
}