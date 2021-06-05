package yang;

/**
 * @Description: 剑指 Offer 14- I. 剪绳子
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * @Author: yangchao
 * @Date: 2021/04/24/18:47
 */

public class CuttingRope {
    /**
     * 动态规划
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        //dp[i] 表示长度为i的绳子剪成m段后的最大乘积。
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            //j 没必要每次都遍历到 i-1, 前半段和后半段是一样的，
            // 比如 7 切分为 3，4 和切分为 4，3 是一样的
            for (int j = 1; j <= i/2; j++) {
                //先把绳子剪掉一段j，如果只剪掉1的话对后面的乘积无任何帮助
                //剪了第一段后，j的长度可剪可不剪 ，第一步分的乘积为Max(j,dp[j])
                int r1 = Math.max(j,dp[j]);
                //同理剩下长度为(i-j),可剪可不剪 ,第二部分的长度为Max(i-j,dp[i-j])
                int r2 = Math.max(i-j,dp[i-j]);
                dp[i] = Math.max(dp[i],r1*r2);
            }
        }
        return dp[n];
    }
}
