package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author fangsheng
 * @date 2021/3/7 下午6:53
 */
public class ThreadPoolDemo01 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = Executors.newSingleThreadExecutor();

    }
}
