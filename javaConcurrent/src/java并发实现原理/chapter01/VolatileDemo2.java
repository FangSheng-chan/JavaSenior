package java并发实现原理.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * @author fangsheng
 * @date 2021/6/24 2:16 下午
 */
class MyData2 {
    volatile int number = 0;

    public  void addTo60() {
        this.number = 60;
    }
}

/**
 * Volatile内存可见性
 *
 * @author ss
 */
public class VolatileDemo2 {
    public static void main(String args[]) {

        // 资源类
        MyData2 myData = new MyData2();

        // AAA线程 实现了Runnable接口的，lambda表达式
        new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "\t come in");

            // 线程睡眠3秒，假设在进行运算
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 修改number的值
            myData.addTo60();

            // 输出修改后的值
            System.out.println(Thread.currentThread().getName() + "\t update number value:" + myData.number);

        }, "AAA").start();

        while (myData.number == 0) {
            // main线程就一直在这里等待循环，直到number的值不等于零
        }

        // 按道理这个值是不可能打印出来的，因为主线程运行的时候，number的值为0，所以一直在循环
        // 如果能输出这句话，说明AAA线程在睡眠3秒后，更新的number的值，重新写入到主内存，并被main线程感知到了
        System.out.println(Thread.currentThread().getName() + "\t mission is over");

    }
}
