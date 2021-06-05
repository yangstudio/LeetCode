package yang;

/**
 * 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class NumDecodings {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0 : 1;
        for (int i = 1; i < len; i++) {
            //最后两位组成10~26之间的数字
            if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) < '7') {
                //10或者20，编码方式唯一
                if (s.charAt(i) == '0') {
                    dp[i+1] = dp[i-1];
                } else {
                    //11~26(不包含20),最后一位单独编码dp[i]、最后两位组合编码dp[i-1]
                    dp[i+1] = dp[i] + dp[i-1];
                }
            } else if (s.charAt(i) == '0'){
                return 0;
            } else {
                //最后一位单独编码dp[i]
                dp[i+1] = dp[i];
            }
        }
        return dp[len];
    }


}
