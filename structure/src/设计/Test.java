package 设计;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author fangsheng
 * @date 2021/6/10 7:20 下午
 */
public class Test {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(3);
        myQueue.push(4);
        myQueue.pop();
        myQueue.push(4);

        Deque queue = new LinkedList();
        queue.push("123");
        System.out.println(queue);
        Stack<Integer> stack = new Stack<>();

        MyStack myStack = new MyStack();
        myStack.push(3);
        myStack.push(4);
        myStack.pop();
    }
}
