package yang;

import java.util.Arrays;

/**
 * @Description: 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 * @Author: yangchao
 * @Date: 2021/03/22/9:07
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        //定义dp数组：dp[i] 表示为组成金额i所需要的最少硬币数量
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        //定义初始状态
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            //完全背包问题，硬币面额可以选取多次
            for (int coin : coins) {
                if (i >= coin) {
                    //状态转移方程
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        //判断是否满足条件，即能否凑满amount数额
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
