package t4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


class Person {
    public int getSum() {
        int sum = 0;
        for (int i = 0; i < 20; i++) {
            sum += i;
        }
        return sum;
    }
}

public class ThreadPool2 {
    public static void main(String[] args) {
        Person person = new Person();
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(5);
        ThreadPoolExecutor.DiscardPolicy discardPolicy = new ThreadPoolExecutor.DiscardPolicy();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 20, 20, TimeUnit.SECONDS, workQueue, discardPolicy);
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+person.getSum());
            }
        });

        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+person.getSum());
            }
        });

        poolExecutor.shutdown();
    }

}
