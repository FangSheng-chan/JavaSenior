package java并发实现原理.chapter01.锁;

/**
 * @author fangsheng
 * @date 2021/6/28 3:26 下午
 */
public class Count {
    private Lock2 lock = new Lock2();

    public void print() throws InterruptedException {
        System.out.println("ready print");
        lock.lock();
        add();
        System.out.println("add success");
        lock.unlock();
        System.out.println("print success");
    }

    public void add() throws InterruptedException {
        lock.lock();
        System.out.println("i am add....");
        lock.unlock();
    }


    public static void main(String[] args) {
        Count count = new Count();
        try {
            count.print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
