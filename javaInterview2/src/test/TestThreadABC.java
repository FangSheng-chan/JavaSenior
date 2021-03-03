package test;

/**
 * @author fangsheng
 * @date 2021/2/26 下午4:23
 */
public class TestThreadABC {

    public static void main(String[] args) {
        Print action = new Print();
        new A(action, "A--->").start();
        new B(action, "B--->").start();
        new C(action, "C--->").start();
    }
}


class A extends Thread {
    Print action;
    String name;

    public A(Print action, String name) {
        super(name);
        this.action = action;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 34; i++) {
            try {
                action.printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class B extends Thread {
    Print action;
    String name;

    public B(Print action, String name) {
        super(name);
        this.action = action;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 33; i++) {
            try {
                action.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class C extends Thread {
    Print action;
    String name;

    public C(Print action, String name) {
        super(name);
        this.action = action;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 33; i++) {
            try {
                action.printC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Print {
    int number = 1;
    int flag = 1;

    public synchronized void printA() throws InterruptedException {
        while (flag != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + number);
        number++;
        flag = 2;
        notifyAll();
    }

    public synchronized void printB() throws InterruptedException {
        while (flag != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + number);
        number++;
        flag = 3;
        notifyAll();
    }

    public synchronized void printC() throws InterruptedException {
        while (flag != 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + number);
        number++;
        flag = 1;
        notifyAll();
    }
}

