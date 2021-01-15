package t4;

import java.util.ArrayList;

class InsertData2 {
    private ArrayList<Integer> list = new ArrayList<>();
    private Object object = new Object();

    public void insert(Thread thread) {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(thread.getName() + "insert number" + i);
                list.add(i);
            }
        }
    }
}

public class t3 {
    public static void main(String[] args) {

    }
}
