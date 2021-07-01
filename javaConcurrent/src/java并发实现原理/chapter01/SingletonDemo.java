package java并发实现原理.chapter01;

/**
 * @author fangsheng
 * @date 2021/6/10 2:24 下午
 */
public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

    public SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonDemo");
    }

    public static SingletonDemo getInstance() {
        if (instance == null) {
            //为了性能，延迟使用synchronized
            // a 双重检查加锁多线程情况下会出现某个线程虽然这里已经为空，但是另外一个线程已经执行到d处
            synchronized (SingletonDemo.class) {
                //c不加 volitale 关键字的话有可能会出现尚未完全初始化就获取到的情况。原因是内存模型允许无序写入
                if (instance == null) {
                   //（1）分配一块内存。（2）在内存上初始化成员变量。（3）把instance引用指向内存。
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }).start();
        }
    }
}
