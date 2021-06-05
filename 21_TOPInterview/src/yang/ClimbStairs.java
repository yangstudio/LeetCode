package yang;

/**
 * @Description: 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * @Author: yangchao
 * @Date: 2021/03/22/15:09
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[n] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
