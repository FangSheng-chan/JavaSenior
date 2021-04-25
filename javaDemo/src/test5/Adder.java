package test5;

/**
 * @author fangsheng
 * @date 2021/4/21 下午6:42
 */
public class Adder {
    private int sum = 0;

    public Adder add(int n) {
        sum += n;
        return this;
    }

    public Adder inc() {
        sum++;
        return this;
    }

    public int value() {
        return sum;
    }
}
