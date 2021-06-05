package yang;

import java.util.Set;

/**
 * @Description: 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 * @Author: yangchao
 * @Date: 2021/03/27/15:47
 */
public class NumDecodings {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            //最后两个数字组成10~26之间的数字
            if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) < '7') {
                //10或者20的编码方式唯一
                if (s.charAt(i) == '0') {
                    dp[i] = i == 1 ? 1: dp[i-2];
                } else {
                    //11~26之间(不包含20)，最后一位单独编码dp[i]、最后两位组合编码dp[i-1]
                    dp[i] = i == 1 ? dp[0] + 1: dp[i-1] + dp[i-2];
                }
            } else if (s.charAt(i) == '0') {  //不能组合成字母
                return 0;
            } else {
                //i-1和i无法构成一个字母, 最后一位单独编码
                dp[i] = dp[i-1];
            }
        }
        String s1 = "";
        return dp[len-1];
    }
}
