package yang;

/**
 * @Description: 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @Author: yangchao
 * @Date: 2021/03/26/10:04
 */
public class MaxProfitII {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        // 0 : 持有现金; 1 : 持有股票
        //dp[i][j] : 表示到下标为 i 的这一天时，我们手上拥有的最大现金数
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        //从第二天开始遍历
        for (int i = 1; i < len; i++) {
            //今天不持股，有两种情况：1. 昨天不持股，今天什么都不做； 2. 昨天持股，今天卖出股票(现金增加)；
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            //今天持股，有两种情况：1. 昨天持股，今天什么都不做；2. 昨天不持股，今天买入股票；
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[len-1][0];
    }
}
