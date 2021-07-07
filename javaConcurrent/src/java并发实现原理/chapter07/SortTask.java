package java并发实现原理.chapter07;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author fangsheng
 * @date 2021/7/6 3:37 下午
 */
public class SortTask extends RecursiveAction {

    final long[] array;
    final int lo, hi;

    SortTask(long[] array, int lo, int hi) {
        this.array = array;
        this.lo = lo;
        this.hi = hi;
    }

    SortTask(long[] array) {
        this(array, 0, array.length);
    }

    @Override
    protected void compute() {
        if (hi - lo < THRESHOLD) {
            sortSequentially(lo, hi);
        } else {
            int mid = (lo + hi) >>> 1;
            invokeAll(new SortTask(array, lo, mid),
                    new SortTask(array, mid, hi));
            merge(lo, mid, hi);
        }
    }

    static final int THRESHOLD = 1000;

    void sortSequentially(int lo, int hi) {
        Arrays.sort(array, lo, hi);
    }

    void merge(int lo, int mid, int hi) {
        long[] buf = Arrays.copyOfRange(array, lo, mid);
        for (int i = 0, j = lo, k = mid; i < buf.length; j++) {
            array[j] = (k == hi || buf[i] < array[k]) ?
                    buf[i++] : array[k++];
        }
    }

//    final long[] array;
//    final int lo;
//    final int hi;
//    /**
//     * for demo only
//     */
//    private int THRESHOLD = 0;
//
//    public SortTask(long[] array) {
//        this.array = array;
//        this.lo = 0;
//        this.hi = array.length - 1;
//    }
//
//    public SortTask(long[] array, int lo, int hi) {
//        this.array = array;
//        this.lo = lo;
//        this.hi = hi;
//    }
//
//    @Override
//    protected void compute() {
//
//    }

    //    private int partition(long[] array, int lo, int hi) {
//        long x = array[hi];
//        int i = lo - ;
//        for (int i = lo; i < hi; i++) {
//            if ()
//        }
//    }
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        forkJoinPool.submit()
    }
}
