package yang;

import java.util.Stack;

/**
 * @Description: 剑指 Offer 30. 包含min函数的栈
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @Author: yangchao
 * @Date: 2021/05/07/8:51
 */
public class MinStack {
    // https://leetcode-cn.com/problems/min-stack/solution/shi-yong-fu-zhu-zhan-tong-bu-he-bu-tong-bu-python-/
    //数据栈
    private Stack<Integer> data;
    //辅助栈
    private Stack<Integer> helper;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }
    //数据栈和辅助栈任何时候都同步
    public void push(int x) {
        data.push(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        } else {
            helper.add(helper.peek());
        }
    }

    public void pop() {
        //两个栈都得pop
        if (!data.isEmpty()) {
            helper.pop();
            data.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return helper.peek();
    }
}
