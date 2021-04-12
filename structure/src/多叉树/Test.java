package 多叉树;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author fangsheng
 * @date 2021/3/30 上午10:40
 */
public class Test {
    public static void main(String[] args) {
        //队列 先进先出
        Deque<Integer> deque = new LinkedList<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println(deque.contains(1));
        while (!deque.isEmpty()) {
            Integer pop = deque.pop();
            System.out.println(pop);
        }
        System.out.println(deque.contains(1));


        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        while (!deque.isEmpty()) {
            Integer pop = deque.pop();
            System.out.println(pop);
        }
    }
}
