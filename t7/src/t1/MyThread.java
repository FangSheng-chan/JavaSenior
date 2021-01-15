package t1;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + "\tis running");
    }

//    public static void main(String[] args) {
//        MyThread myThread1 = new MyThread();
//        MyThread myThread2 = new MyThread();
//
//        myThread1.start();
//        myThread2.start();
//    }
}
