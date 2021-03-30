package test4;

/**
 * @author fangsheng
 * @date 2021/3/9 下午2:07
 */
public class T1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
//        User user = new User("ss", "123");
//        new Thread(() -> {
//            t1.processUser(user);
//        }).start();
    }

    ThreadLocal<User> userThreadLocal = new ThreadLocal<>();


    void processUser(User user) {
        try {
            userThreadLocal.set(user);
            step1();
            step2();
        } finally {
            userThreadLocal.remove();
        }
    }

    void step1() {
        User user = userThreadLocal.get();
        log();
        System.out.println(user);
    }

    void log() {
        System.out.println(userThreadLocal.get().getName());
    }

    void step2() {
        User user = userThreadLocal.get();
        System.out.println(user.getId());
    }

    static void log(String s) {
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }
}
