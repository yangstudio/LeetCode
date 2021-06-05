package yang;

import org.junit.Test;

/**
 * @Description: 剑指 Offer 58 - I. 翻转单词顺序
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * @Author: yangchao
 * @Date: 2021/06/01/14:13
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length-1; i >= 0; i--) {
                if (strs[i].length() != 0) {
                    String temp = strs[i].trim();
                    sb.append(temp);
                    if (i != 0) sb.append(" ");
            }
        }
        return sb.toString();
    }
    @Test
    public void test(){
        ReverseWords rs = new ReverseWords();
        String s = "a good   example";
        String res = rs.reverseWords(s);
        String t = "";
        System.out.println(t.length());
        System.out.println(res);
    }
}
