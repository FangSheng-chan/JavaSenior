package java并发实现原理.chapter01;

/**
 * @author fangsheng
 * @date 2021/6/8 4:57 下午
 */
class Data {
    private long a = 0;

    public void set(long a) {
        this.a = a;
    }

    public long get() {
        return this.a;
    }
}

public class T16 {
    public static void main(String[] args) {
        Data data = new Data();

        new Thread(() -> {
            data.set(3);
        }).start();
    }
}
