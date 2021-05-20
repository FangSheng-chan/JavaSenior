package 阻塞队列_8;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fangsheng
 * @date 2021/5/7 11:11 上午
 */
public class NamedThreadFactory implements ThreadFactory {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("调度线程："+atomicInteger.getAndIncrement());
        return thread;
    }
}
