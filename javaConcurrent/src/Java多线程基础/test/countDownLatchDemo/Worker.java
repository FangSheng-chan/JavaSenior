package Java多线程基础.test.countDownLatchDemo;

/**
 * 假设一条流水线上有三个工作者：worker0，worker1，worker2。有一个任务的完成需要他们三者协作完成，
 * worker2可以开始这个任务的前提是worker0和worker1完成了他们的工作，而worker0和worker1是可以并行他们各自的工作的。
 * <p>
 * 如果我们要编码模拟上面的场景的话，我们大概很容易就会想到可以用join来做。当在当前线程中调用某个线程 thread 的 join() 方法时，
 * 当前线程就会阻塞，直到thread 执行完成，当前线程才可以继续往下执行。
 * join的工作原理是，不停检查thread是否存活，如果存活则让当前线程永远wait，直到thread线程终止，线程的this.notifyAll 就会被调用。
 *
 * @author fangsheng
 * @date 2021/7/11 6:37 下午
 */
public class Worker extends Thread {

    private String name;
    private long time;

    public Worker(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(name + "开始工作");
        try {
            Thread.sleep(time);
            System.out.println(name + "工作完成，耗时=\t" + time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
