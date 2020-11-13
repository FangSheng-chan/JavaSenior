package t1;


public class ThreadDemo2 {
    public static void main(String args[]) {
        MyThread2 mt = new MyThread2();
        Thread t = new Thread(mt);
        t.start();
        while (true) {
            System.out.println("兔子领先了，加油");
        }
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("乌龟超过了，再接再厉");
        }
    }
}
