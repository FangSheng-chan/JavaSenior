package threadDemo;

/**
 * @author fangsheng
 * @date 2021/2/24 下午2:52
 */
public class Thread03 {
    public static void main(String[] args) throws InterruptedException {
        MyThread2 thread2 = new MyThread2();
        thread2.start();
        Thread.sleep(1);
        thread2.interrupt();
        thread2.join();
        System.out.println("end");
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
        }
    }
}
