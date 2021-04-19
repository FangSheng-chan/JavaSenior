package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fangsheng
 * @date 2021/4/18 下午6:29
 */
public class T1 {
    public static void main(String[] args) {
        System.out.println("主线程执行");

        ExecutorService es1 = Executors.newSingleThreadExecutor();
        es1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("子线程："+Thread.currentThread().getName()+"执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        es1.shutdown();

        ExecutorService es2 = Executors.newSingleThreadExecutor();
        es2.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("子线程："+Thread.currentThread().getName()+"执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        es2.shutdown();


    }
}
