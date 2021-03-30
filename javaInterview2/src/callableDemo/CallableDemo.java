package callableDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


/**
 * @author fangsheng
 * @date 2021/3/7 下午6:16
 */

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("come in callable");
        return 1024;
    }
}

/**
 * @author ss
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        Thread thread = new Thread(futureTask, "AAA");
        Thread thread2 = new Thread(futureTask, "BBB");
        thread.start();
        thread2.start();
        int result = 100;
        while (!futureTask.isDone()) {

        }
        //get 方法放在最后
        int result2 = futureTask.get();
        System.out.println(result + result2);
    }
}
