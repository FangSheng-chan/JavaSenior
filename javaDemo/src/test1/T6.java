package test1;

/**
 * @author fangsheng
 * @date 2021/3/3 下午2:20
 */
public class T6 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName()+ finalI);
            },String.valueOf(i)).start();
        }
    }
}
