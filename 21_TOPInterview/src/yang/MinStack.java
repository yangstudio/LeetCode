package yang;

import java.util.Stack;

/**
 * @Description: 155. 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 * @Author: yangchao
 * @Date: 2021/04/08/14:16
 */
public class MinStack {
    Stack<Integer> data;
    Stack<Integer> help; //栈顶元素始终为当前栈中的最小元素-
    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        help = new Stack<>();
        help.push(Integer.MAX_VALUE);
    }
    //数据栈和辅助栈任何时候都同步
    public void push(int val) {
        //数据栈和辅助栈一定会增加元素
        data.push(val);
        help.push(Math.min(val,help.peek()));

    }

    public void pop() {
        //两个栈都pop
        if (!data.isEmpty()) {
            help.pop();
            data.pop();
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if (!help.isEmpty()) {
            return help.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */