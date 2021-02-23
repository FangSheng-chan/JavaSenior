package volatileDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangsheng
 * @date 2021/2/22 下午3:46
 */
class MyData {

    volatile int number = 0;

    private Lock lock = new ReentrantLock();


    public void addTo60() {
        this.number = 60;
    }

//    public synchronized void addPlusPlus() {
//        number++;
//    }

    public void addPlusPlus() {
        lock.lock();
        try {
            number++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * @author ss
 */
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();

        // 创建20个线程，线程里面进行1000次循环
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                }
            }, String.valueOf(i)).start();
        }

        // 需要等待上面20个线程都计算完成后，在用main线程取得最终的结果值
        // 这里判断线程数是否大于2，为什么是2？因为默认是有两个线程的，一个main线程，一个gc线程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t finally number value:" + myData.number);
    }


    private static void isOkVisibility() {
        MyData myData = new MyData();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "\t come in");

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myData.addTo60();
                System.out.println(Thread.currentThread().getName() + "\t update number value:" + myData.number);
            }
        });
        thread.setName("AAA");
        thread.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println("Thread 内部类");
            }
        }.start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update number value:" + myData.number);
        }, "BBB").start();

        while (myData.number == 0) {

        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }
}
