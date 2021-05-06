package synchronized和lock的区别_9;


import javax.annotation.Resource;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 早期的时候我们对线程的主要操作为：
 * - synchronized wait notify
 * 然后出现的替代方案
 * - lock await signal
 * <p>
 * synchronized 和 lock 的区别
 * 1、synchronized 是属于 JVM层面的，属于 Java 关键字 ； ReentrantLock 是具体类，是api层面的锁
 * 2、synchronized 不需要用户去手动释放锁，当synchronized执行执行后，系统会自动让线程释放对锁的占有；ReentrantLock 则需要用户去手动释放锁，若没有主动释放锁，就有可能出现死锁
 * 的现象，需要lock()和unlock()配置try catch语句来完成
 * 3、synchronized 不可中断，除非抛出异常或者正常运行完成；
 * ---ReentrantLock:可中断，可以设置超时方法: trylock(long timeout,TimeUnit unit)
 * 4、synchronized 非公平锁；ReentrantLock 默认是非公平锁，构造方法可以传参
 * 5、锁绑定多个条件
 * ---synchronized：没有，要么随机，要么全部唤醒
 * ---ReentrantLock：用来实现分组唤醒需要唤醒的线程，可以精确唤醒，而不是像synchronized那样，要么随机，要么全部唤醒
 */

/**
 * 1、锁的三部曲：判断、干活、唤醒
 * 2、为了避免虚假唤醒，一定要采用 while
 */
class ShareResource {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            while (number != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t " + number + "\t");
            // 唤醒
            number = 2;
            // 通知2号去干活
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            while (number != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t " + number + "\t" );
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            while (number != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t " + number + "\t" );
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}

public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print5();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print10();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print15();
            }
        }, "C").start();
    }
}
