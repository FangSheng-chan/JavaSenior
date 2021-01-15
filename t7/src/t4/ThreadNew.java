package t4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadNew {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
//        FutureTask futureTask = new FutureTask<>(numThread);
//        new Thread(futureTask).start();
//
//        try {
//            Object sum = futureTask.get();
//            System.out.println("总和：" + sum);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        new Thread(new FutureTask<>(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                int sum = numThread.getSum();
                System.out.println(sum);
                return sum;
            }
        })).start();

    }
}
