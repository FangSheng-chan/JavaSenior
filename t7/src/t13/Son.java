package t13;

/**
 * @author fangsheng
 * @date 2021/5/14 4:16 下午
 */
public class Son  extends Father{

    public Son(int age) {
        super(age);
    }

    public Son() {

    }

    @Override
    public String toString() {
        return "Son{}";
    }

    public static void main(String[] args) {
        Son son = new Son(20);
    }
}
