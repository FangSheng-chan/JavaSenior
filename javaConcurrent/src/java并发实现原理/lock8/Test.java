package java并发实现原理.lock8;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author fangsheng
 * @date 2021/7/7 3:19 下午
 */

class Task implements Runnable {

    private final AtomicReference<Thread> cas;
    private final SpinLock spinLock;

    public Task(AtomicReference<Thread> cas) {
        this.cas = cas;
        this.spinLock = new SpinLock(cas);
    }

    @Override
    public void run() {
        spinLock.lock();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        spinLock.unlock();
    }
}

/**
 * 可重入自旋锁验证
 */
class Task1 implements Runnable{
    private final AtomicReference<Thread> cas;
    private final ReentrantSpinLock slock ;

    public Task1(AtomicReference<Thread> cas) {
        this.cas = cas;
        this.slock = new ReentrantSpinLock(cas);
    }

    @Override
    public void run() {
        slock.lock(); //上锁
        slock.lock(); //再次获取自己的锁！没问题！
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        slock.unlock(); //释放一层，但此时count为1，不为零，导致另一个线程依然处于忙循环状态，所以加锁和解锁一定要对应上，避免出现另一个线程永远拿不到锁的情况
        slock.unlock();
    }
}

public class Test {
    public static void main(String[] args) {
        AtomicReference<Thread> cas = new AtomicReference<>();
        Thread thread1 = new Thread(new Task1(cas));
        Thread thread2 = new Thread(new Task1(cas));
        thread1.setName("A");
        thread2.setName("B");
        thread1.start();
        thread2.start();
    }
}
