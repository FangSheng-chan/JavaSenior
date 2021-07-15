package java并发实现原理;

/**
 * @author fangsheng
 * @date 2021/7/8 10:41 下午
 */
public class PrintAB {

    public void printA(){
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A");
//        notify();
    }

    public void printB(){
        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("B");
        notify();
    }
}
