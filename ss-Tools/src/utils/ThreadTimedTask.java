package utils;

import java.util.concurrent.TimeUnit;

/**
 * @author fangsheng
 * @date 2021/5/20 9:37 上午
 */
public class ThreadTimedTask {
    public static void main(String[] args) {
        init();
    }

    /**
     * 使用场景：比如项目中有时需要每隔10分钟去下载某个文件，或者每隔5分钟去读取模板文件生成静态html页面等等，一些简单的周期性任务场景。
     */
    public static void init() {
        new Thread(() -> {
            while (true) {
                System.out.println("do Something");
                try {
                    TimeUnit.SECONDS.sleep(3L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
