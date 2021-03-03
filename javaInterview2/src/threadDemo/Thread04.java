package threadDemo;

/**
 * @author fangsheng
 * @date 2021/2/24 下午2:56
 */
public class Thread04 {
    public static void main(String[] args) throws InterruptedException {
        MyThread3 myThread3 = new MyThread3();
        myThread3.start();
        Thread.sleep(500);
        myThread3.interrupt();
        myThread3.join();
        System.out.println("end");
    }
}

class MyThread3 extends Thread {
    @Override
    public void run() {
        HelloThread helloThread = new HelloThread();
        helloThread.start();
        try {
            helloThread.join();
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
        helloThread.interrupt();
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello !");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
