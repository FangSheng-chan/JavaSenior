package java并发实现原理.chapter02;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author fangsheng
 * @date 2021/6/16 2:42 下午
 */
public class LongAddrDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlus();
                    myData.addPlus2();
                }
            }, String.valueOf(i)).start();
        }
        // 需要等待上面20个线程都计算完成后，在用main线程取得最终的结果值
        // 这里判断线程数是否大于2，为什么是2？因为默认是有两个线程的，一个main线程，一个gc线程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + myData.longAdder);
        System.out.println(Thread.currentThread().getName() + myData.number);
    }
}

class MyData {

    volatile int number = 0;

    LongAdder longAdder = new LongAdder();

    public void addPlus(){
        longAdder.increment();
    }

    public void addPlus2(){
        number++;
    }
}
