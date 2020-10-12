package t1;

public class e2 {

    public static void main(String[] args) {
        s s = new s();
        s.run();
        s s1 = new s();
        s1.run();

    }

    static class s implements Runnable{

        @Override
        public void run() {
            System.out.println("ss");
        }
    }
}
