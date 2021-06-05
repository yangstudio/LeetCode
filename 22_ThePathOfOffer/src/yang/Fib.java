package yang;

/**
 * @Description: 剑指 Offer 10- I. 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * @Author: yangchao
 * @Date: 2021/04/19/8:51
 */
public class Fib {
    public int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
}
