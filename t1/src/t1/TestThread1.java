package t1;

class RabbitRunnable implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("兔子领先了...." +
                    Thread.currentThread().getName() + "" + Thread.currentThread().getPriority());
        }
    }
}

class TortoiseThread extends Thread {

    private String name;

    private TortoiseThread() {

    }

    public TortoiseThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("乌龟领先了......" + getName() + "" + getPriority());
        }
    }
}

public class TestThread1 {
    public static void main(String[] args) {
        RabbitRunnable rabbitRunnable = new RabbitRunnable();
        Thread thread = new Thread(rabbitRunnable);
        thread.setName("兔子线程");
        thread.start();

        TortoiseThread tortoiseThread = new TortoiseThread("乌龟线程");
        tortoiseThread.start();
    }
}
