package volatile_1.volatile_3禁止指令重排;

/**
 * @author fangsheng
 * @date 2021/4/14 下午2:08
 */
public class ResortSeqDemo {
    volatile int a = 0;
    volatile boolean flag = false;

    public void method01() {
        a = 1;
        flag = true;
    }

    public void method2(){
        if (flag){
            a = a+5;
            System.out.println("reValue:" + a);
        }
    }

    public static void main(String[] args) {

        ResortSeqDemo resortSeqDemo = new ResortSeqDemo();

        for (int i = 0; i < 1000; i++) {
            new Thread(() ->{
                resortSeqDemo.method01();
                resortSeqDemo.method2();
            }).start();
        }
    }
}
