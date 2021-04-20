package s5;

/**
 * @author fangsheng
 * @date 2021/4/19 下午7:18
 */
public class T4 {
    static int s;
    int i;
    int j;

    {
        int i = 1;
        i++;
        j++;
        s++;
        System.out.println("我执行了");
    }

    public void test(int j) {
        j++;
        i++;
        s++;
    }

    public static void main(String[] args) {
        T4 obj1 = new T4();
        T4 obj2 = new T4();
        obj1.test(10);
        obj1.test(20);
        obj2.test(30);
        System.out.println(obj1.i + "," + obj1.j + "," + s);
        System.out.println(obj2.i + "," + obj2.j + "," + s);
    }
}
