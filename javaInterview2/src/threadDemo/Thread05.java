package threadDemo;

/**
 * @author fangsheng
 * @date 2021/2/24 下午3:09
 */
public class Thread05 {
    public static void main(String[] args) throws InterruptedException {
        HelloThread2 helloThread2 = new HelloThread2();
        helloThread2.start();
        Thread.sleep(1);
        helloThread2.running = false;
    }
}

class HelloThread2 extends Thread {

    public  boolean running = true;

    @Override
    public void run() {
        int n = 0;
        while (running) {
            n++;
            System.out.println(n + " hello");
        }
        System.out.println("end");
    }
}
