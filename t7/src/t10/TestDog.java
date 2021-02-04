package t10;

/**
 * @author fangsheng
 * @date 2021/2/4 下午2:38
 */
class Animal {
    public void move() {
        System.out.println("动物可以移动");
    }
}

class Dog extends Animal {
    @Override
    public void move() {
        System.out.println("狗可以跑和走");
    }

    public void bark() {
        System.out.println("狗可以吠叫");
    }
}

public class TestDog {
    public static void main(String args[]) {
        // 父类的引用指向子类的实例
        Animal a = new Animal(); // Animal 对象
        Dog b = new Dog(); // Dog 对象

        a.move();// 执行 Animal 类的方法
        b.move();//执行 Dog 类的方法
        b.bark();
    }
}
