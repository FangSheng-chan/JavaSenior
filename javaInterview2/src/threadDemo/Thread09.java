package threadDemo;

/**
 * @author fangsheng
 * @date 2021/2/24 下午4:42
 */
public class Thread09 {
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                counter1.add(1);
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                counter1.dec(2);
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                counter2.dec(2);
            }).start();
        }
        System.out.println(counter1.get());
        System.out.println(counter2.get());
    }
}

class Counter {
    private int count = 0;

    public void add(int n) {
        synchronized (Counter.class) {
            count += n;
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void dec(int n) {
        synchronized (this) {
            count -= n;
        }
    }

    public int get() {
        return count;
    }
}
