package t5;

public class test {
    public static void main(String[] args) {
        MyService service = new MyService();
        MyThread m1 = new MyThread(service);
        MyThread m2 = new MyThread(service);
        MyThread m3 = new MyThread(service);
        m1.start();
        m2.start();
        m3.start();
    }
}
