package test4;

import java.nio.ByteBuffer;
import java.util.Hashtable;

/**
 * @author fangsheng
 * @date 2021/4/1 下午3:23
 */
public class T9 {
    public static void main(String[] args) {
        T9 t9 = new T9();
        t9.test();
        Byte b = 127;
        Byte b2 = 127;
        b = b++;
        b2 = ++b2;
        System.out.println(b);
        System.out.println(b2);
    }


    public void add(Byte b) {
        b = b++;
    }

    public void test() {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.println(a + " ");
        add(b);
        System.out.println(b + "");
    }
}


class Demo {
    class Super {

        int flag = 1;

        Super() {
            test();
        }

        void test() {
            System.out.println("Super.test() flag=" + flag);
        }
    }

    class Sub extends Super {

        Sub(int i) {
            flag = i;
            System.out.println("Sub.Sub()flag=" + flag);
        }

        @Override
        void test() {
            System.out.println("Sub.test()flag=" + flag);
        }
    }

    public static void main(String[] args) {
        /**
         * 重点在于要时刻记得子类重写父类方法，调用时会调用子类重写之后的方法
         * 当然，这一切的前提都是 实例化子类对象
         */
        new Demo().new Sub(5);
        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
    }
}

class A {
    public float getNum() {
        return 3.0f;
    }
}

class B extends A {

}
