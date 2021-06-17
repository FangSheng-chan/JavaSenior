package java并发实现原理.chapter03;

/**
 * @author fangsheng
 * @date 2021/6/16 3:36 下午
 */
public class Synchronizeddemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendSMS();
        }, "t1").start();

        new Thread(() -> {
            phone.sendSMS();
        }, "t2").start();
    }
}

class Phone {
    public synchronized void sendSMS() {
        System.out.println(Thread.currentThread().getName() + "\t invoked sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getId() + "\t invoked sendEmail()");
    }
}
