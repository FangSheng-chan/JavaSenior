package java并发实现原理.chapter06;

import java.util.concurrent.Callable;

/**
 * @author fangsheng
 * @date 2021/6/29 4:55 下午
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "ss";
    }
}
