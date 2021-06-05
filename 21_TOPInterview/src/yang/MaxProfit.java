package yang;

/**
 * @Description: 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @Author: yangchao
 * @Date: 2021/03/26/9:08
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int len = prices.length;
        int res = 0;
        //第i天卖出股票的获利
        int[] dp = new int[len];
        //从第二天开始遍历
        for (int i = 1; i < len; i++) {
            //状态转移方程：第i天可以获得的利润 = 第i-1天最大利润 + 利润差
            dp[i] = dp[i-1] + prices[i] - prices[i-1];
            dp[i] = Math.max(dp[i],0);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //考虑空间优化
    public int maxProfitII (int[] prices) {
        if (prices.length == 1) return 0;
        int len = prices.length;
        int res = 0;
        //前一天卖出可以获得的最大利润
        int prev = 0;
        //从第二天开始遍历
        for (int i = 1; i < len; i++) {
            //利润差
            int diff = prices[i] - prices[i-1];
            //状态转移方程：第i天卖出可以获得的最大利润 = 第i-1天卖出可以获得的最大利润 + 利润差
            prev = Math.max(prev + diff, 0);
            res = Math.max(res,prev);
        }
        return res;
    }
}
