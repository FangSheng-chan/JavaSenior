package t2;

/***
 * 线程通信的列子
 *
 * 涉及3个方法：
 *  wait()
 *  notify();
 *  notifyAll();
 *  wait();notify();notifyAll();
 *
 *  面试题： sleep() 和 wait() 的异同
 *  1、相同点：一旦执行方法，都可以使得当前的线程进入阻塞
 *  2、不同点： 1）
 *
 */
class Number1 implements Runnable {

    private int number = 1;

    @Override
    public  void run() {
        while (true) {
            synchronized (this) {

                this.notifyAll();

                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number1 number = new Number1();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        Thread t3 = new Thread(number);

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();


    }
}
