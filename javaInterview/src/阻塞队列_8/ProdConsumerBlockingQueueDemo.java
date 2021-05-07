package 阻塞队列_8;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fangsheng
 * @date 2021/4/26 3:19 下午
 */
class MyResource {
    /**
     * 这里用到volatile是为了保持数据的可见性，也就是当FLAG修改时，要马上通知其他线程进行修改
     */
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    /**
     * 生产
     *
     * @throws Exception
     */
    public void myProd() throws Exception {
        String data;
        boolean retValue;
        // 多线程都用 while 判断
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            //2秒存入一个data
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列：" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列：" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t 停止生产，表示FLAG = false ,生产介绍");
    }

    /**
     * 消费
     *
     * @throws Exception
     */
    public void myConsumer() throws Exception {
        String retValue;
        while (FLAG) {
            retValue = blockingQueue.poll(2L, TimeUnit.SECONDS);

            if(null == retValue || retValue.equalsIgnoreCase("")){
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 消费失败，队列中已为空，退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列：" + retValue + "成功");
        }
    }

    public void stop() {
        this.FLAG = false;
    }

}

/**
 * @author ss
 */
public class ProdConsumerBlockingQueueDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(1));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            System.out.println("");
            System.out.println("");
            try {
                myResource.myProd();
                System.out.println("");
                System.out.println("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5秒中后，生产和消费线程停止，线程结束");
        myResource.stop();
    }
}
