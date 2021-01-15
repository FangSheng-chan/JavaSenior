package t1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class dThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "新建线程睡了2s后返回结果";
    }
}

public class MyThread5 {
    public static void main(String[] args) {
        dThread dThread = new dThread();
        FutureTask<String> futureTask = new FutureTask<>(dThread);
        new Thread(futureTask, "A").start();
        System.out.println("提前完成任务....");
        try {
            System.out.println("线程执行结果为------" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
