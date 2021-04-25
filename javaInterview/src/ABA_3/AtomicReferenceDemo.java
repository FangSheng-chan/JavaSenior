package ABA_3;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子引用类
 */

/**
 * @author fangsheng
 * @date 2021/4/22 下午3:39
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User z3 = new User("z3", 22);
        User l4 = new User("l4", 25);

        AtomicReference<User> userAtomicReference = new AtomicReference<>();

        userAtomicReference.set(z3);

        System.out.println(userAtomicReference.compareAndSet(z3, l4) + "\t" + userAtomicReference.get());

        System.out.println(userAtomicReference.compareAndSet(z3, l4) + "\t" + userAtomicReference.get());
    }
}
