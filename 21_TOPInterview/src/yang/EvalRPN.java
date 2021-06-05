package yang;

import java.util.Stack;

/**
 * @Description: 150. 逆波兰表达式求值
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @Author: yangchao
 * @Date: 2021/04/09/9:47
 */

public class EvalRPN {
    public int evalRPN(String[] tokens) {
       Stack<Integer> stack = new Stack<>();
       for (String str : tokens) {
           int a, b;
           switch (str) {
               case "+":
                   b = stack.pop();
                   a = stack.pop();
                   stack.push(a+b);
                   break;
               case "-":
                   b = stack.pop();
                   a = stack.pop();
                   stack.push(a-b);
                   break;
               case "*":
                   b = stack.pop();
                   a = stack.pop();
                   stack.push(a*b);
                   break;
               case "/":
                   b = stack.pop();
                   a = stack.pop();
                   stack.push(a/b);
                   break;
               default:
                   stack.push(Integer.parseInt(str));
           }
       }
       return stack.peek();
    }

    private boolean isNumeriec(String str) {
        if (str.matches("\\d*")) return true;
        return false;
    }
}
