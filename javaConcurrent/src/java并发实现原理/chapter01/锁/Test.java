package java并发实现原理.chapter01.锁;

/**
 * @author fangsheng
 * @date 2021/6/23 12:04 下午
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ObjectService objectService = new ObjectService();
        new Thread(() -> {
            objectService.serviceMethodI();
        },"B").start();
        new Thread(() -> {
            ObjectService.serviceMethodH();
        },"A").start();
    }
}

class Share implements Runnable {

    private Object object = new Object();

    public void s1() throws InterruptedException {
        synchronized (object) {
            System.out.println("a begin");
            Thread.sleep(3000);
            System.out.println("a end");

        }
    }

    public void s2() {
        synchronized (Share.class) {
            System.out.println("b begin");
            System.out.println("b end");
        }
    }

    public void s3() throws InterruptedException {
        synchronized (this) {
            Thread.sleep(3000);
            System.out.println("zzzzzz");
        }
    }

    @Override
    public void run() {
        try {
            s1();
            s2();
            s3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
