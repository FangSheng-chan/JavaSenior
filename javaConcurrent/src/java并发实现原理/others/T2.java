package java并发实现原理.others;

/**
 * @author fangsheng
 * @date 2021/7/8 2:28 下午
 */
public class T2 {
    public static void main(String[] args) {
//        Work work = new Work();
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                for (int j = 0; j < 2000; j++) {
//                    work.add();
//                }
//            }).start();
//        }
//        while (Thread.activeCount() > 2) {
//            Thread.yield();
//        }
//        System.out.println(work.num);
        Work2 work2 = new Work2();
        new Thread(() -> {
            work2.setLower(8);
        }).start();
        new Thread(() -> {
            work2.setUpper(2);
        }).start();

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(work2.getLower());
        System.out.println(work2.getUpper());
    }
}

class Work {

    int num = 0;

    public int get() {
        return num;
    }

    public void add() {
        num++;
    }
}

class Work2 {
    private volatile int lower;
    private volatile int upper = 10;

    public int getLower() {
        return lower;
    }

    public int getUpper() {
        return upper;
    }

    public void setLower(int lower) {
        if (lower > upper) {
            throw new IllegalArgumentException();
        }
        this.lower = lower;
    }

    public void setUpper(int upper) {
        if (upper < lower) {
            throw new IllegalArgumentException();
        }
        this.upper = upper;
    }
}