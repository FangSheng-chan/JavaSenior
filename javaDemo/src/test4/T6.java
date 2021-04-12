package test4;

/**
 * @author fangsheng
 * @date 2021/3/30 下午2:40
 */
public class T6 {

    public T6() {
        System.out.println("T6的构造方法");
    }

//    {
//        System.out.println("T6的构造代码块");
//    }
//
//    static {
//        System.out.println("T6的静态代码块");
//    }

    protected void ss() {
        System.out.println("123");
    }



    public static void main(String[] args) {
        T6 t6 = new T6();
    }
}
