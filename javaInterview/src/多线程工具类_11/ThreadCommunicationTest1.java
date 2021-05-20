package 多线程工具类_11;

import java.util.LinkedList;
import java.util.List;

/**
 * @author fangsheng
 * @date 2021/5/7 11:21 上午
 */
public class ThreadCommunicationTest1 {

    private volatile MyContainer1 myContainer1 = new MyContainer1();

    public void f1() {
        synchronized (this) {
            for (int i = 1; i <= 10; i++) {
                System.out.println("add" + i);
                if (i == 5) {
                    this.notify();
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void f2() {
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("size == 5");
            this.notify();
        }
    }

    public static void main(String[] args) {
        ThreadCommunicationTest1 threadCommunicationTest1 = new ThreadCommunicationTest1();
        new Thread(threadCommunicationTest1::f2).start();
        new Thread(threadCommunicationTest1::f1).start();
    }
}

class MyContainer1 {
    List<String> list = new LinkedList();

    public void add(String s) {
        list.add(s);
    }

    public int size() {
        return list.size();
    }
}