package yang;

/**
 * @Description: 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * @Author: yangchao
 * @Date: 2021/03/10/14:18
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char chr = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                //第j个字符串长度比它小或者第j个字符串中第i个字符与chr不相等
                if (i == strs[j].length() || strs[j].charAt(i) != chr){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
