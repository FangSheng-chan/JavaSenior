package java并发实现原理.chapter01;

/**
 * @author fangsheng
 * @date 2021/6/7 7:10 下午
 */

class MyThreadTest implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " START ....");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " over");
    }
}

public class YieldTest {
    public static void main(String[] args) {
        MyThreadTest t1 = new MyThreadTest();
        new Thread(t1,"A").start();
        new Thread(t1,"B").start();
        new Thread(t1,"C").start();
    }
}
