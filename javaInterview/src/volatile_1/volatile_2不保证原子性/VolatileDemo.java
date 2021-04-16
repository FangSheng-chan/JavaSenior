package volatile_1.volatile_2不保证原子性;

/**
 * @author fangsheng
 * @date 2021/4/7 下午4:45
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 假设是主物理内存
 */
class MyData {
    volatile int number = 0;

    AtomicInteger atomicInteger = new AtomicInteger();

    public synchronized void addPlusPlus() {
        number++;
    }

    public void addAtomic(){
        atomicInteger.getAndAdd(1);
    }
}

public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        // 创建10个线程，线程里面进行1000次循环
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                // 里面
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            }, String.valueOf(i)).start();
        }

        // 需要等待上面20个线程都计算完成后，在用main线程取得最终的结果值
        // 这里判断线程数是否大于2，为什么是2？因为默认是有两个线程的，一个main线程，一个gc线程
        while (Thread.activeCount() > 2) {
            // yield表示不执行
            Thread.yield();
        }

        // 查看最终的值
        // 假设volatile保证原子性，那么输出的值应该为：  20 * 1000 = 20000
        System.out.println(Thread.currentThread().getName() + "\t finally number value: " + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t finally atomicInteger value: " + myData.atomicInteger);


    }
}
