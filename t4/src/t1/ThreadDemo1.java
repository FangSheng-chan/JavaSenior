package t1;

public class ThreadDemo1 {
    public static void main(String args[]) {
        MyThread1 t = new MyThread1();
        t.start();
        while (true) {
            System.out.println("兔子领先了，别骄傲");
        }
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("乌龟领先了，加油");
            yield();
//            try {
//                sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}