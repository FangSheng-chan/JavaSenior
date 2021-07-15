package java并发实现原理;

/**
 * @author fangsheng
 * @date 2021/7/8 9:46 下午
 */
public class Test {
    public static void main(String[] args) {
        Print1 print1 = new Print1();
        PrintAB printAB = new PrintAB();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                printAB.printA();
//                printAB.printB();
            }
        }).start();

    }
}
