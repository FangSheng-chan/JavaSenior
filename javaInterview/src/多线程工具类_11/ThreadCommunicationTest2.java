package 多线程工具类_11;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangsheng
 * @date 2021/5/7 2:10 下午
 */
public class ThreadCommunicationTest2 {

    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();

    public void f1() {
        lock.lock();
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("add" + i);
                if (i == 5) {
                    c2.signal();
                    c1.await();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void f2() {
        lock.lock();
        try {
            c2.await();
            System.out.println("size 等于5");
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void f3() {
        lock.lock();
        for (int i = 1; i <= 10; i++) {
            System.out.println("add" + i);
            if (i == 5) {
                c2.signal();
                try {
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        lock.unlock();
    }

    public void f4() {
        lock.lock();
        try {
            c2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("size等于5啦！！！");
        c1.signal();
        lock.unlock();
    }

    public static void main(String[] args) {
        ThreadCommunicationTest2 t = new ThreadCommunicationTest2();
        new Thread(t::f4);
        new Thread(t::f3);
    }
}
