package t5;

import java.util.concurrent.*;

public class test4 {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1, 2,
                6, TimeUnit.SECONDS,
                null,
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
