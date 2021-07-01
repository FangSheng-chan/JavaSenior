package java并发实现原理.chapter01;

/**
 * SingletonDemo.getInstance() 获取到的对象不是同一个
 *
 * @author fangsheng
 * @date 2021/6/24 2:27 下午
 */
public class SingletonDemo2 {
    private static SingletonDemo2 instance = null;

    private SingletonDemo2() {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonDemo");
    }

    public static SingletonDemo2 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo2();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingletonDemo2.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
