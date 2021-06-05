package yang;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: 剑指 Offer 50. 第一个只出现一次的字符
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * @Author: yangchao
 * @Date: 2021/05/20/14:24
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';
        char[] chs = s.toCharArray();
        Map<Character,Boolean> map = new LinkedHashMap<>();
        for (char ch : chs) {
            map.put(ch,!map.containsKey(ch));
        }
        for (char ch : chs) {
            if (map.get(ch)) return ch;
        }
        return ' ';
    }
}
