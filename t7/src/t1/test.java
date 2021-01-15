package t1;

public class test {
    public static void main(String[] args) {
        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();

        m1.start();
        m2.start();
    }
}
