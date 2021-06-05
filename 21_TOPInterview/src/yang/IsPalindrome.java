package yang;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description: 9. 回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 * @Author: yangchao
 * @Date: 2021/03/02/8:37
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x / 10 == 0) return true;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();
        while (x != 0) {
            int temp = x % 10;
            stack.push(temp);
            queue.offer(temp);
            x /= 10;
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.poll()) return false;
        }
        return true;
    }
}
