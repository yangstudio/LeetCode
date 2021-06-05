package yang;

import java.util.Stack;

/**
 * @Description: 剑指 Offer 09. 用两个栈实现队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * @Author: yangchao
 * @Date: 2021/04/19/8:26
 */
public class CQueue {
    Stack<Integer> instack;
    Stack<Integer> outstack;

    public CQueue() {
        instack = new Stack<>();
        outstack = new Stack<>();
    }

    public void appendTail(int value) {
        instack.push(value);
    }

    public int deleteHead() {
        //如果第二个栈为空
        if (outstack.isEmpty()) {
            while (!instack.isEmpty()) {
                outstack.push(instack.pop());
            }
        }
        if (outstack.isEmpty()) return -1;
        return outstack.pop();
    }
}
