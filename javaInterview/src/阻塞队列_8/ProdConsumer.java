package 阻塞队列_8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fangsheng
 * @date 2021/5/7 9:32 上午
 */

class Res {
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<Integer> blockingQueue = null;

    public Res(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    /**
     * 生产者
     */
    public void Prod() throws InterruptedException {
        boolean retValue;
        while (FLAG) {
            int data = atomicInteger.incrementAndGet();
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t 停止生产，表示FLAG = false ,生产结束");
    }

    public void Consumer() throws InterruptedException {
        Integer retValue;
        while (FLAG) {
            retValue = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (retValue == 0 || retValue == null){
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 消费失败，队列中已为空，退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列：" + retValue + "成功");
        }
    }

    public void stop(){
        this.FLAG = false;
    }
}

/**
 * @author ss
 */
public class ProdConsumer {
    public static void main(String[] args) throws InterruptedException {
        Res res = new Res(new ArrayBlockingQueue<>(1));

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    res.Prod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"Prod").start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    res.Consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"Consumer").start();
        }

        TimeUnit.SECONDS.sleep(5);

        res.stop();
    }
}















