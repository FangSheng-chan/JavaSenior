package 反射;

import java.io.Serializable;

/**
 * @author fangsheng
 * @date 2021/3/18 下午4:16
 */
public abstract class Creature<T> implements Serializable {
    public char gender;
    private double weight;

    private void breath() {
        System.out.println("我会呼吸");
    }

    public void eat() {
        System.out.println("真好吃呀");
    }
}
