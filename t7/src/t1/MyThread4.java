package t1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyThread4 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("正在执行新建线程任务");
        Thread.sleep(2000);
        return "新建线程睡了2s后返回执行结果";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread4 myThread4 = new MyThread4();
        FutureTask<String> futureTask = new FutureTask<>(myThread4);
        Thread thread = new Thread(futureTask, "A");
        thread.start();
        System.out.println("提前完成任务....");

        String result = futureTask.get();
        System.out.println(Thread.currentThread().getName()+"\t线程执行结果为-------" + result);

    }
}
