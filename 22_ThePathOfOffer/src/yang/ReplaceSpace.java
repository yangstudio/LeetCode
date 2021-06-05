package yang;

/**
 * @Description: 剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * @Author: yangchao
 * @Date: 2021/04/15/14:21
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        if (s == null) return "%20";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) ==  ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
