package yang;

/**
 * @Description: 28. 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 * @Author: yangchao
 * @Date: 2021/03/15/8:36
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        if (haystack == null || haystack.length() < needle.length()) return -1;
        int len = haystack.length();
        int k = needle.length();
        for (int i = 0; i < len-k+1; i++) {
            if (haystack.substring(i,i+k).equals(needle)) return i;
        }
        return -1;
    }
}
