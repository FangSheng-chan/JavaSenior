package threadDemo;

/**
 * @author fangsheng
 * @date 2021/2/24 下午2:37
 */
public class Thread02 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("hello");
        });
        System.out.println("start");
        thread.start();
        thread.join();
        System.out.println("end");
    }
}
