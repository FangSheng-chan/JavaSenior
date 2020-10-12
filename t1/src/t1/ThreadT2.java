package t1;

class MThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadT2 {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        Thread thread = new Thread(mThread);
        thread.setName("线程1");
        thread.start();

        Thread thread2 = new Thread(mThread);
        thread2.setName("线程2");
        thread2.start();
    }
}
