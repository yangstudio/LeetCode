package yang;

import java.util.Stack;

/**
 * @Description: 232. 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * @Author: yangchao
 * @Date: 2021/04/08/8:38
 */
public class MyQueue {
        /** Initialize your data structure here. */
        Stack<Integer> inStack;
        Stack<Integer> outStack;
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!outStack.isEmpty()) {
            inStack.push(outStack.pop());
        }
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
