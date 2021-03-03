package threadDemo;

/**
 * @author fangsheng
 * @date 2021/2/25 下午3:07
 */
public class Thread10 {

}

class Counter3 {
    private int count = 0;

    public synchronized void add(int n) {
        if (n < 0) {
            dec(-n);
        } else {
            count += n;
        }
    }

    public synchronized void dec(int n) {
        count += n;
    }
}
