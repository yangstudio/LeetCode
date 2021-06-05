package yang;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @Author: yangchao
 * @Date: 2020/12/15/8:39
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        //哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<>();
        int len = s.length();
        //右指针，初始值为-1.相当于我们在字符串的左边界的左侧，还没开始移动
        int right = -1;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                //左侧指针向右移动一格，移除一个字符
                set.remove(s.charAt(i-1));
            }
            while (right + 1 < len && !set.contains(s.charAt(right + 1))) {
                //不断地移动右指针
                set.add(s.charAt(right+1));
                right++;
            }
            //第i到第right个字符是一个无重复的字符子串
            res = Math.max(res,right - i + 1);
        }
        return res;
    }
}
