package volatile_1.volatile_4应用;

/**
 * @author fangsheng
 * @date 2021/4/14 下午2:30
 */
public class SingletonDemo {
    private volatile static SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingleDemo");
    }

    public static SingletonDemo getInstance() {
        if (instance == null) {
            // a 双重检查加锁多线程情况下会出现某个线程虽然这里已经为空，但是另外一个线程已经执行到d处
            synchronized (SingletonDemo.class) {
                //c不加volatile关键字的话有可能会出现尚未完全初始化就获取到的情况。原因是内存模型允许无序写入
                if (instance == null) {
                    // d 此时才开始初始化
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
            }, String.valueOf(i)).start();
        }
    }
}
