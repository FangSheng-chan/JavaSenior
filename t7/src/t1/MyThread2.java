package t1;


class ss implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"\timplement Runnable is Running");
    }
}

public class MyThread2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ss());
        Thread thread2 = new Thread(new ss());


        thread1.run();
        thread1.start();
        thread2.start();

    }
}
