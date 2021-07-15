package java并发实现原理.chapter08;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author fangsheng
 * @date 2021/7/8 4:01 下午
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {

        /**
         * 无返回值
         */
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
//            System.out.println(Thread.currentThread().getName() + "没有返回，update mysql ok");
//        });
//        completableFuture.get();

        /**
         * 有返回
         */
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "有返回，update mysql ok");
            int i = 10 / 0;
            return 1024;
        });

        Integer getCompletableFuture1 = completableFuture1.whenComplete((t, u) -> {
            System.out.println("t\t" + t);
            System.out.println("u\t" + u);
        }).exceptionally(f -> {
            System.out.println("exception\t" + f.getMessage());
            return 444;
        }).get();

        System.out.println(getCompletableFuture1);

    }
}
