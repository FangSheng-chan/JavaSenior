package java并发实现原理.chapter06;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangsheng
 * @date 2021/6/24 3:52 下午
 */
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
        int a = 3 << 2;
        System.out.println(a);
        // Array Arrays(辅助工具类）
        // Collection Collections(辅助工具类）
        // Executor Executors（辅助工具类）
        System.out.println(COUNT_BITS);
        System.out.println(CAPACITY);
        System.out.println(RUNNING);
//        System.out.println(ctlOf(RUNNING, 0));
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();

    }

}
