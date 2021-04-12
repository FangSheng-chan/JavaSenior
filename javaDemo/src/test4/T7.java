package test4;

/**
 * @author fangsheng
 * @date 2021/3/30 下午3:01
 */
public class T7 extends T6 {

    public T7() {
        System.out.println("T7的构造方法");
    }

//    {
//        System.out.println("T7的构造代码块");
//    }
//
//    static {
//        System.out.println("T7的静态代码块");
//    }

    @Override
    public void ss() {
        System.out.println("ss");
    }

    public void ss(String s) {
        System.out.println(s.length());
        System.out.println("ss");
    }

    public static void main(String[] args) {
        T7 t7 = new T7();
        t7.ss();
    }
}
