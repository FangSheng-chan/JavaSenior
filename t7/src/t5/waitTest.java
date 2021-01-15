package t5;

class Lock {

}

class ThreadA extends Thread {
    Lock lock;

    public ThreadA(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("ThreadA线程：获得lock锁");
            System.out.println("ThreadA线程：执行结束释放lock锁");
        }
    }
}


class ThreadB extends Thread {
    Lock lock;

    public ThreadB(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("ThreadB线程：获得lock锁");
            System.out.println("ThreadB线程：执行结束释放锁");
        }
    }
}

public class waitTest {
    public static void main(String[] args) {
        Lock lock = new Lock();
        ThreadA threadA = new ThreadA(lock);
        ThreadB threadB = new ThreadB(lock);
        synchronized (lock) {
            try {
                System.out.println("主线程：启动threadA线程");
                threadA.start();
                System.out.println("主线程：启动threadB线程");
                threadB.start();

                System.out.println("主线程：此时lock锁在主线程这里");
                System.out.println("主线程：调用wait方法释放锁");
                lock.wait(1000);

                System.out.println("主线程：wait方法结束，重新获得lock锁");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

