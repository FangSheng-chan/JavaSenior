package java并发实现原理.chapter06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangsheng
 * @date 2021/6/24 3:52 下午
 */

class MyThread implements Runnable {

    String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程:" + Thread.currentThread().getName() + " 执行:" + name + "  run");
    }
}

public class ExcutorServiceDemo {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;
    private static final int RUNNING = -1 << COUNT_BITS;


    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }


    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 0,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(2),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 1; i < 6; i++) {
            System.out.println("添加第" + i + "个任务");
            executor.execute(new MyThread("线程" + i));
            Iterator iterator = executor.getQueue().iterator();
            while (iterator.hasNext()) {
                MyThread thread = (MyThread) iterator.next();
                System.out.println("列表：" + thread.name);
            }
        }
        executor.shutdown();
//        int a = 3 << 2;
//        System.out.println(a);
        // Array Arrays(辅助工具类）
        // Collection Collections(辅助工具类）
        // Executor Executors（辅助工具类）
//        System.out.println(COUNT_BITS);
//        System.out.println(CAPACITY);
//        System.out.println(RUNNING);
//        System.out.println(ctlOf(RUNNING, 0));
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();

    }

}
