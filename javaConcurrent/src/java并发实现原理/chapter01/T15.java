package java并发实现原理.chapter01;

/**
 * @author fangsheng
 * @date 2021/6/8 4:39 下午
 */
class C {

    public void f1() {
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void f2() {
        synchronized (this) {
            this.notify();
        }
    }
}

public class T15 {
}
