package yang;

import java.util.Stack;

/**
 * 224. 基本计算器
 * https://leetcode-cn.com/problems/basic-calculator/
 */
public class Calculate {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        int res = calculate(s);
        System.out.println(res);
    }

    public static int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> symStack = new Stack<>();
        char operator = 0;
        int num1 = 0, num2 = 0, operand = 0;
        boolean isValid = false;
        int res = 0;

        for (int i = 0; i < s.length(); i++ ) {
           char ch = s.charAt(i);

           if (Character.isDigit(ch)) {
               operand = 10*operand + (ch-'0');
                isValid = true;

               if (s.length() == 1) return operand;
               //最后一个元素是数字，直接返回
               if (i == s.length()-1 ) {
                   numStack.push(operand);
               }
           } else {
               if (isValid) {
                   numStack.push(operand);
                   operand = 0;
                   isValid = false;
               }
                if (ch == '+' || ch == '-' || ch == '(') {
                      /*连续两个减法运算或者前面一个是减法运算后面是加法运算，需要把前面的结果计算出来
                      例如：2 - 1 + 2 = 3，如果不处理的话，根据栈的特性，计算过程如下：(1) 1 + 2 = 3，入栈；(2) 2 - 3 = -1;*/
                   if ((ch == '+' || ch == '-') && !symStack.isEmpty() && symStack.peek() == '-') {
                       num2 = numStack.pop();
                       num1 = numStack.pop();
                       res = num1 - num2;
                       symStack.pop();
                       numStack.push(res);
                   }
                   symStack.push(ch);
               } else if (ch == ')') {
                   while((operator = symStack.pop()) != '(') {
                       num2 = numStack.pop();
                       num1 = numStack.pop();
                       if (operator == '+') {
                           res = num1 + num2;
                       } else if (operator == '-') {
                           res = num1 - num2;
                       }
                       numStack.push(res);
                   }
               }
           }
        }

        while(!symStack.isEmpty()) {
            operator = symStack.pop();
            num2 = numStack.pop();
            num1 = numStack.pop();
            if (operator == '+') {
                res = num1 + num2;
            } else if (operator == '-') {
                res = num1 - num2;
            }
            numStack.push(res);
        }

        return numStack.pop();
    }
}
