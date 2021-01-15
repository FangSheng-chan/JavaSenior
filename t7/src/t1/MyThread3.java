package t1;

public class MyThread3 {
    public static void main(String[] args) {
        // 方式1：相当于继承类Thread类，作为子类重写run()实现
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "匿名内部类创建线程方式1...");
                }
            }.start();
        }


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"\t匿名内部类创建线程方式2...");
            }
        }, "A").start();


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t匿名内部类");
        }, "A").start();

    }
}
