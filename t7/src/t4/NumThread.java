package t4;

import java.util.concurrent.Callable;

public class NumThread {
    public int getSum() {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
