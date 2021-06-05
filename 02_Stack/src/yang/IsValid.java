package yang;

import java.util.HashMap;
import java.util.Stack;

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 */

public class IsValid {

    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        //key-value
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Stack<Character> stack = new Stack<>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                if (c != map.get(stack.pop())) return false;
            }
        }
        return stack.isEmpty();
    }
}
