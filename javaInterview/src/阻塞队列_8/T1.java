package 阻塞队列_8;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fangsheng
 * @date 2021/5/7 11:00 上午
 */
public class T1 {
    public static void main(String[] args) {
        ShareSS shareSS = new ShareSS();
        ExecutorService executorService = Executors.newFixedThreadPool(2, new NamedThreadFactory());
        executorService.execute(() -> {
            for (int i = 0; i < 3; i++) {
                shareSS.inc();
            }
        });

        executorService.execute(() -> {
            for (int i = 0; i < 3; i++) {
                shareSS.dec();
            }
        });
        executorService.shutdown();
    }
}
