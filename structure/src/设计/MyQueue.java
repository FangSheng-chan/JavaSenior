package 设计;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用栈实现队列
 *
 * @author fangsheng
 * @date 2021/6/10 6:56 下午
 */
public class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        this.inStack = new LinkedList<>();
        this.outStack = new LinkedList<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

}
