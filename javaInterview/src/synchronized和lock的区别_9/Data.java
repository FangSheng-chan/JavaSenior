package synchronized和lock的区别_9;

import java.util.concurrent.Callable;

/**
 * @author fangsheng
 * @date 2021/4/29 5:07 下午
 */
public class Data implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return null;
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {

    }
}
