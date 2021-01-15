package t4;

import java.util.ArrayList;

class InsertData {
    private ArrayList<Integer> list = new ArrayList<>();

    public synchronized void insert(Thread thread) {
        for (int i = 0; i < 5; i++) {
            System.out.println(thread.getName() + "insert number " + i);
            list.add(i);
        }
    }
}

public class t2 {
    public static void main(String[] args) {
        final InsertData insertData = new InsertData();

        new Thread() {
            @Override
            public void run() {
                insertData.insert(Thread.currentThread());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                insertData.insert(Thread.currentThread());
            }
        }.start();
    }
}
