package t4;


class ss {
    public int sum() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = sum + i;
        }
        return sum;
    }
}

public class t7 {
    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
