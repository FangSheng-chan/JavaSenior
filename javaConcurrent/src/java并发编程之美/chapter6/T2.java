package java并发编程之美.chapter6;

public class T2 {
    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(() -> {
            System.out.println("thread A is waiting to get lock");
            synchronized (lock){
                try {
                    System.out.println("thread A get lock");
                    System.out.println("thread A do sleep method");
                    Thread.sleep(1000);
                    System.out.println("thread A is done");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            //等待线程A执行完毕再执行线程B
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        new Thread(() -> {
            System.out.println("thread B is waiting to get lock");
            synchronized (lock){
                try {
                    System.out.println("thread B get lock");
                    System.out.println("thread B is wait 10 ms");
                    lock.wait(100);
                    System.out.println("thread B is done");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
