package yang;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description: 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @Author: yangchao
 * @Date: 2021/04/09/8:58
 */
public class IsValid {
    public boolean isValid(String s) {
        if (s.length()%2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                stack.push(map.get(ch));
            } else {
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
        /*if (!stack.isEmpty()) return false;
        return true;*/
    }
}
