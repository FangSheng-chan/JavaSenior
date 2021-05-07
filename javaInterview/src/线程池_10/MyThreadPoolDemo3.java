package 线程池_10;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * @author fangsheng
 * @date 2021/5/6 3:55 下午
 */
public class MyThreadPoolDemo3 {

    static Queue<String> queue = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 1; i < 10; i++) {
            queue.offer("task" + i);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        for (int i = 0; i < queue.size(); i++) {
            ScheduledFuture<String> scheduledFuture = executorService.schedule(() -> {
                String value = queue.poll();
                if (value != "" && null != value) {
                    System.out.println("时间：" + sdf.format(new Date()) + "\t线程" + Thread.currentThread().getName() + "\t执行task：" + value);
                }
                return "call";
            }, 1, TimeUnit.SECONDS);
            System.out.println(scheduledFuture.get());
        }
        executorService.shutdown();
    }
}
