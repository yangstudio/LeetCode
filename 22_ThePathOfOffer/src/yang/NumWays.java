package yang;

/**
 * @Description: 剑指 Offer 10- II. 青蛙跳台阶问题
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * @Author: yangchao
 * @Date: 2021/04/19/9:05
 */
public class NumWays {
    public int numWays(int n) {
        int[] dp = new int[n+1];
        if (n <= 1) return 1;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
}
