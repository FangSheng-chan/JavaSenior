package java并发编程之美.chapter6;

public class T1 {
    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(() -> {
            System.out.println("thread A is waiting to get lock");
            synchronized (lock){
                try {
                    System.out.println("thread A get lock");
                    System.out.println("thread A do wait method");
                    lock.wait(1000);
                    System.out.println("thread A is done");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            //让线程A先执行
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        new Thread(() -> {
            System.out.println("thread B is waiting to get lock");
            synchronized (lock){
                try {
                    System.out.println("thread B get lock");
                    System.out.println("thread B is sleeping 1000 ms");
                    Thread.sleep(2000);
                    System.out.println("thread B is done");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
