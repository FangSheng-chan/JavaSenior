package 反射;

import java.io.Serializable;

/**
 * @author fangsheng
 * @date 2021/3/14 下午4:12
 */
public class User implements Serializable, Person {
    public void show() {
        System.out.println("i am chinese");
    }
}
