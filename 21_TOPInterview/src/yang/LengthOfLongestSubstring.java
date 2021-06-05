package yang;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Author: yangchao
 * @Date: 2021/03/28/9:07
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len <= 1) return len == 0 ? 0 : 1;
        char[] strs = s.toCharArray();
        int res = 1;
        int slow = 0, fast = 0;
        Set<Character> set = new HashSet<>();
        while(fast < len) {
            while( fast < len && !set.contains(strs[fast])) {
                set.add(strs[fast]);
                fast++;
            }
            set.remove(strs[slow]);
            res = Math.max(res,fast-slow);
            slow++;
            //if (fast < slow) fast = slow; fast不会比slow小，自己debug一下就知道了
        }
        return res;
    }
}
