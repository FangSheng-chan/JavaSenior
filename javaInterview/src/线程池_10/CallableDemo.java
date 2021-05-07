package 线程池_10;

import java.util.concurrent.*;

/**
 * @author fangsheng
 * @date 2021/4/30 9:55 上午
 */
class MyThread implements Callable<Integer> {
    /**
     * Callable有返回值
     *
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(3);
        System.out.println(Thread.currentThread().getName() + "come in Callable");
        return 1024;
    }
}

/**
 * @author ss
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // FutureTask：实现了Runnable接口，构造函数又需要传入 Callable接口
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        Thread thread = new Thread(futureTask, "aaa");
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        }).start();
        thread.start();
        System.out.println("result FutureTask " + futureTask.get());
    }
}











