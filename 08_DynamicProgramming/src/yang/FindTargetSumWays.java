package yang;

/**
 * 494. 目标和
 * https://leetcode-cn.com/problems/target-sum/
 */
public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int S) {
       int sum = 0;
       for (int num : nums) {
           sum += num;
       }
       if (((sum + S) & 1) == 1 || S > sum) return 0;
       int len = (sum + S) >> 1;
       int[] dp = new int[len+1];
       for (int num : nums) {
           for (int i = len; i >= num; i--) {
               if (i == num) {
                   dp[i] += 1;
                   continue;
               }
               dp[i] += dp[i-num];
           }
       }
       return dp[len];
    }
}
