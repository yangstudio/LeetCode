package yang;

import org.junit.Test;

import java.util.Arrays;

public class Change {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

  /*  public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if(i >= coin) {
                    dp[i] += dp[i-coin];
                }
            }
        }
        return dp[amount];
    }*/


    @Test
    public void changeTest(){
        int[] coins = new int[] {1,2,5};
        Change ch = new Change();
        int res = ch.change(5, coins);
        System.out.println(res);
    }
}
