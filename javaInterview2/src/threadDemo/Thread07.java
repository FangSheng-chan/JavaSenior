//package threadDemo;
//
///**
// * @author fangsheng
// * @date 2021/2/24 下午3:55
// */
//public class Thread07 {
//    public static void main(String[] args) throws InterruptedException {
//        AddThread addThread = new AddThread();
//        DecThread decThread = new DecThread();
//        addThread.start();
//        decThread.start();
//        addThread.join();
//        decThread.join();
//        System.out.println(Counter.count);
//    }
//}
//
//class Counter {
//    public static final Object lock = new Object();
//
//    public static int count = 0;
//}
//
//class AddThread extends Thread {
//    @Override
//    public void run() {
//        for (int i = 0; i < 10000; i++) {
//            synchronized (Counter.lock) {
//                Counter.count += 1;
//            }
//        }
//    }
//}
//
//class DecThread extends Thread {
//    @Override
//    public void run() {
//        for (int i = 0; i < 10000; i++) {
//            synchronized (Counter.lock) {
//                Counter.count -= 1;
//            }
//        }
//    }
//}
//
