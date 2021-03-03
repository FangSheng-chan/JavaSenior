package test1;

/**
 * @author fangsheng
 * @date 2021/3/1 下午1:50
 */
public class t1 extends t2{
    public static void main(String[] args) {
        t1 t1 = new t1();
        t1.send();
        System.out.println(t1.write());
    }

    String write() {
        return super.get();
    }

    @Override
    void send() {
        System.out.println("send");
    }
}
