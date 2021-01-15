package t4;


class MyRunnable {

    public void getName() {
        for (int i = 0; i < 30; i++) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + " ：loop：" + i);
        }
    }
}

public class t5 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myRunnable) {
                    myRunnable.getName();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                myRunnable.getName();
            }
        },"C").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myRunnable) {
                    myRunnable.getName();
                }
            }
        }, "B").start();
    }
}
