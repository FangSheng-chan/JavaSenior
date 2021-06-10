package java并发实现原理.chapter01;

/**
 * A的方法等价于B的方法
 * 对于非静态成员函数，锁其实是加在对象a上面的；
 * 对于静态成员函数，锁是加在A.class上面的。当然，class本身也是对象。
 * @author fangsheng
 * @date 2021/6/8 4:04 下午
 */
class A {

    public synchronized void f1() {

    }

    public synchronized static void f2() {

    }

}

class B {
    public void f1() {
        synchronized (this) {

        }
    }

    public void f2() {
        synchronized (B.class) {

        }
    }
}

public class T14 {


}

