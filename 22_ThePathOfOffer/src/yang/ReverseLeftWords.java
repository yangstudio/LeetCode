package yang;

/**
 * @Description: 剑指 Offer 58 - II. 左旋转字符串
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * @Author: yangchao
 * @Date: 2021/06/02/8:27
 */
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        if (s.length() == 0) return s;
        int k = n % s.length();
        if (k == 0) return s;
        String res = s.substring(k,s.length()) + s.substring(0,k);
        return res;
    }
}
