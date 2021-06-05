package yang;

import org.junit.Test;

import java.util.Stack;

/**
 * @Description: 剑指 Offer 31. 栈的压入、弹出序列
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * @Author: yangchao
 * @Date: 2021/05/08/8:20
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) return true;
        Stack<Integer> inSack = new Stack<>();
        Stack<Integer> outStack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            if (inSack.contains(popped[j])) {
                outStack.push(inSack.pop());
                //为什么i要减1呢？,因为当前循环中只是判断popped[j]是否在stack中，
                // 下一次循环时i变为(i+1),导致pushed[i]没有入栈
                i -= 1;
                j++;
                continue;
            }
            inSack.push(pushed[i]);
            if (pushed[i] == popped[j]) {
                outStack.push(inSack.pop());
                j++;
            }

        }
        while (!inSack.isEmpty()) {
            outStack.push(inSack.pop());
        }
        int index = pushed.length-1;
        while (!outStack.isEmpty()) {
            if (outStack.pop() != popped[index]) return false;
            index--;
        }
        return true;
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testForValidateStackSequences() {
        int[] pushed = new int[] {2,1,0};
        int[] poped = new int[] {2,1,0};
        ValidateStackSequences vss = new ValidateStackSequences();
        boolean res = vss.validateStackSequences(pushed, poped);
        System.out.println(res);
    }
}
