package synchronized和lock的区别_9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangsheng
 * @date 2021/4/29 4:50 下午
 */

class OddEvenNumber {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();

    public void printOdd() {
        lock.lock();
        try {
            while (number % 2 != 0) {
                condition1.await();
            }
            System.out.println(number);
            number++;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printEven() {
        lock.lock();
        try {
            while (number % 2 == 0) {
                condition2.await();
            }
            System.out.println(number);
            number++;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        OddEvenNumber oddEvenNumber = new OddEvenNumber();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                oddEvenNumber.printOdd();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                oddEvenNumber.printEven();
            }
        }).start();
    }
}
