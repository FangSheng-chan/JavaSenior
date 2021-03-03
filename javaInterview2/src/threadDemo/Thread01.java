package threadDemo;

/**
 * @author fangsheng
 * @date 2021/2/22 下午4:34
 */
public class Thread01 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new MyRunnable());
        thread1.setPriority(6);
        thread1.start();

        new Thread(() -> {
            System.out.println("start");
        }).start();

//        System.out.println("main start");

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println("thread run...");
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("thread end...");
            }
        };
        thread2.setPriority(1);
        thread2.start();


//        try {
//            Thread.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("main end ...");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thead !");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new Runnable !");
    }
}

