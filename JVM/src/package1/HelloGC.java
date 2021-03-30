package package1;

/**
 * @author fangsheng
 * @date 2021/3/24 下午12:51
 */
public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello****");
        Thread.sleep(Integer.MAX_VALUE);
    }
}