package test2;

/**
 * @author fangsheng
 * @date 2021/2/25 下午6:02
 */
//@EqualsAndHashCode
public class TestJd {
    public static void main(String args[]) throws InterruptedException {
        JDSB jdsb = new JDSB();
        JDSB jdsb2 = new JDSB();


//        new Thread(new ThreadA(jdsb), "A").start();
//
//        new Thread(new ThreadB(jdsb2), "B").start();

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 1000; i++) {
//                    synchronized (JDSB.class) {
//                        JDSB.count += 1;
//                    }
//                }
//            }
//        });
//        thread.start();


//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 1000; i++) {
//                    synchronized (JDSB.class) {
//                        JDSB.count -= 1;
//                    }
//                }
//            }
//        });
//        thread1.start();
//        thread.join();
//        thread1.join();
//        System.out.println(JDSB.count);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 1000; i++) {
//                    synchronized (JDSB.class) {
//                        System.out.println(i);
//                    }
//                }
//            }
//        }).start();


        for (int i = 0; i < 100; i++) {

        }

        for (int i = 0; i < 100; i++) {

        }

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    jdsb.add();
                }
            }
        });
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    jdsb.dec();
                }
            }
        });
        thread1.start();
        thread.start();

        thread.join();
        thread1.join();

//        new Thread(jdsb::add).start();
//        new Thread(jdsb::dec).start();
        System.out.println(jdsb.get());
    }

}
