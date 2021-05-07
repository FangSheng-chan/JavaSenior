package 阻塞队列_8;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 当阻塞队列是空时，从队列中获取元素的操作将会被阻塞
 * 当阻塞队列是满时，从队列中添加元素的操作将会被阻塞
 * <p>
 * 在多线程领域：所谓的阻塞，在某些清空下会挂起线程（即阻塞），一旦条件
 * <p>
 * // 你用过 List集合类
 * // ArrayList集合类
 * // 还用过 CopyOnWriteList 和 BlockingQueue
 * <p>
 * - ArrayBlockQueue
 * - LinkedBlockingQueue
 * - SynchronousQueue
 * 不存储元素的阻塞队列，也即单个元素的队列生产一个，消费一个，不存储元素，不消费不生产
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<Object> blockingQueue = new SynchronousQueue();
        Thread thread = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put A ");
                blockingQueue.put("A");

                System.out.println(Thread.currentThread().getName() + "\t put B ");
                blockingQueue.put("B");

                System.out.println(Thread.currentThread().getName() + "\t put C ");
                blockingQueue.put("C");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        Thread thread2 = new Thread(() -> {
            try {

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take A ");

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take B ");

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take C ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(thread);
        executorService.execute(thread2);
        executorService.shutdown();
    }

    /**
     * add、remove、element 会抛出异常
     */
    @Test
    public void t1() {
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.add("ss"));
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.element());
//        System.out.println(blockingQueue.element());
    }

    /**
     * offer:成功就是true,失败就是 false
     * poll:成功返回队列元素，队列没有就返回空
     */
    @Test
    public void t2() {
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
//        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }

    /**
     * 阻塞队列组
     * <p>
     * 1、我们使用put的方法，添加元素的时候，如果阻塞队列满了后，添加消息的线程，就会一个阻塞，直到队列元素减少，
     * 会被清空，才会唤醒
     * 2、一般在消息中间件，比如RabbitMQ中会使用到，因为需要保证消息百分百不丢失，因此只有让它阻塞
     * 3、同时使用take取消息的时候，如果内容不存在的时候，也会被阻塞
     *
     * @throws InterruptedException
     */
    @Test
    public void t3() throws InterruptedException {
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
//        blockingQueue.take();
    }

    /**
     * offer(),poll() 加时间
     * 使用offer、poll插入的时候，需要指定时间，如果2秒还没有插入，那么就放弃插入
     *
     * @throws InterruptedException
     */
    @Test
    public void t4() throws InterruptedException {
        BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c", 2L, TimeUnit.SECONDS));
//        System.out.println(blockingQueue.offer("d", 2L, TimeUnit.SECONDS));

        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
    }
}
