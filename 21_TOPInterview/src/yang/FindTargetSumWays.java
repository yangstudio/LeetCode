package yang;

/**
 * @Description: 494. 目标和
 * https://leetcode-cn.com/problems/target-sum/
 * @Author: yangchao
 * @Date: 2021/03/23/15:50
 */
public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0) return 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (((sum-S)&1)== 1 || sum < S) return 0;
        int tar = (sum-S) >> 1;
        int len = nums.length;
        int[][] dp = new int[len+1][tar+1];
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            //唯一和【416题】不一样的就是num可以为0，因此要从j=0开始遍历
            for (int j = 0; j <= tar; j++) {
                dp[i][j] = dp[i-1][j];
                if (nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[len][tar];
    }

    //考虑空间优化
    public int findTargetSumWaysII(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (((sum-S)&1)== 1 || sum < S) return 0;
        int tar = (sum-S) >> 1;
        int len = nums.length;
        int[] dp = new int[tar+1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = tar; i >= num; i--) {
                dp[i] += dp[i-num];
            }
        }
        return dp[tar];
    }
}
