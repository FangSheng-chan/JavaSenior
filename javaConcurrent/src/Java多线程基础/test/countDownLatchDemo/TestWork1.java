package Java多线程基础.test.countDownLatchDemo;

/**
 * @author fangsheng
 * @date 2021/7/11 6:42 下午
 */
public class TestWork1 {
    public static void main(String[] args) throws InterruptedException {
        Worker worker0 = new Worker("worker0", (long) (Math.random()*2000+3000));
        Worker worker1 = new Worker("worker1", (long) (Math.random()*2000+3000));
        Worker worker2 = new Worker("worker2", (long) (Math.random()*2000+3000));
        worker0.start();
        worker1.start();
        worker0.join();
        worker1.join();
        System.out.println("准备工作就绪");
        worker2.start();
    }
}
