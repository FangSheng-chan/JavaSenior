package threadDemo;

/**
 * @author fangsheng
 * @date 2021/2/24 下午4:14
 */
public class Thread08 {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = {new AddStudentThread(), new DecStudentThread(), new AddTeacherThread(), new DecTeacherThread()};
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(Counter2.studentCount);
        System.out.println(Counter2.teacherCount);
    }
}

class Counter2 {
    public static final Object lockStudent = new Object();
    public static final Object lockTeacher = new Object();
    public static int studentCount = 0;
    public static int teacherCount = 0;
}

class AddStudentThread extends Thread {
    @Override
    public void run() {
        synchronized (Counter2.lockStudent) {
            for (int i = 0; i < 1000; i++) {
                Counter2.studentCount += 1;
            }
        }
    }
}

class DecStudentThread extends Thread {
    @Override
    public void run() {
        synchronized (Counter2.lockStudent) {
            for (int i = 0; i < 1000; i++) {
                Counter2.studentCount -= 1;
            }
        }
    }
}

class AddTeacherThread extends Thread {
    @Override
    public void run() {
        synchronized (Counter2.lockTeacher) {
            for (int i = 0; i < 1000; i++) {
                Counter2.teacherCount += 1;
            }
        }
    }
}

class DecTeacherThread extends Thread {
    @Override
    public void run() {
        synchronized (Counter2.lockTeacher) {
            for (int i = 0; i < 1000; i++) {
                Counter2.teacherCount -= 1;
            }
        }
    }
}
