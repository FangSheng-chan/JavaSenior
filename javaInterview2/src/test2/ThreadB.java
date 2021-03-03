package test2;

/**
 * @author fangsheng
 * @date 2021/2/25 下午6:03
 */
public class ThreadB implements Runnable {
    JDSB jdsb=null;
    public ThreadB(JDSB jdsb) {
        this.jdsb=jdsb;
    }

    @Override
    public void run() {
        JDSB.sayA();
    }
}