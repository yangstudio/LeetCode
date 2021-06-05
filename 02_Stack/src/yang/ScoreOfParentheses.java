package yang;

import java.util.Stack;

/**
 * 856. 括号的分数
 * https://leetcode-cn.com/problems/score-of-parentheses/
 */

public class ScoreOfParentheses {
    public static void main(String[] args) {
        String S = "(()(()))";
        int score = scoreOfParentheses(S);
        System.out.println(score);
    }
    public static int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int len = S.length();
        char lastChar = 0, c = 0;
        for (int i = 0; i < len; i++) {
            c = S.charAt(i);
            if (c == '(') {
                stack.push(0);
            } else {
                Integer t = stack.pop();
                if (lastChar == '(') {
                    stack.push(stack.pop()+1);
                } else {
                    stack.push(stack.pop() + (t << 1));
                }
            }
            lastChar = c;
        }
        return stack.pop();
    }
}
