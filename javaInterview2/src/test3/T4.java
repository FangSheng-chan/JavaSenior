package test3;

import java.util.List;

/**
 * @author fangsheng
 * @date 2021/3/3 下午3:48
 */
public class T4 {

    static ThreadLocal<List> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) {
        log("start main");
        new Thread(() -> {
            log("run task");
        }).start();
        new Thread(() -> {
            log("print");
        }).start();
        log("end main");
    }

    static void log(String s) {
        System.out.println(Thread.currentThread().getName() + ":" + s);
    }
}


