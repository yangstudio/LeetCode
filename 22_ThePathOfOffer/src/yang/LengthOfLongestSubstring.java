package yang;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 剑指 Offer 48. 最长不含重复字符的子字符串
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 * @Author: yangchao
 * @Date: 2021/05/19/14:58
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1) return len == 0 ? 0 : 1;
        char[] chs = s.toCharArray();
        int res = 1;
        int slow = 0, fast = 0;
        Set<Character> set = new HashSet<>();
        while(fast < len) {
            while (fast < len && !set.contains(chs[fast])) {
                set.add(chs[fast]);
                fast++;
            }
            set.remove(chs[slow]);
            res = Math.max(res,fast-slow);
            slow++;
        }
        return res;
    }
}
