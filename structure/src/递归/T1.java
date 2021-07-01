package 递归;

/**
 * @author fangsheng
 * @date 2021/6/29 9:53 上午
 */
public class T1 {
    public static void main(String[] args) {
        System.out.println(FibonacciSequence(3));
        System.out.println(jumpingFrog(4));
    }

    /**
     * 斐波那契数列 求第n项的值
     *
     * @param n
     * @return
     */
    public static int FibonacciSequence(int n) {
        if (n <= 2) {
            return 1;
        }
        return FibonacciSequence(n - 1) + FibonacciSequence(n - 2);
    }

    public static int jumpingFrog(int n) {
        if (n <= 2) {
            return n;
        }
        return jumpingFrog(n - 1) + jumpingFrog(n - 2);
    }
}
