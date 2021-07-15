package java并发实现原理;

/**
 * @author fangsheng
 * @date 2021/7/8 9:43 下午
 */
public class Print1 {

    public synchronized void print100() {
        try {
            wait();
            System.out.println(System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(100);
    }


    public synchronized void notifyAllPrint1() {
        this.notifyAll();
    }

}
