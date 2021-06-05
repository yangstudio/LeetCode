package yang;

/**
 * 416. 分割等和子集[ 0-1背包问题 ]
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class CanPartition {
    /**
     * 考虑空间优化
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //如果数组和为奇数，不符合要求
        if ((sum & 1) == 1)  return false;
        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        //dp[j - nums[i-1]]用到了dp[0],当j == nums[i-1]时显然为true
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = target; j >= nums[i-1]; j--) {
                if (dp[target]) return true;
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }
        return dp[target];
    }

    public boolean canPartition1(int[] nums) {
        int len = nums.length;
        if (len == 0) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //如果数组和为奇数，不符合要求
        if ((sum & 1) == 1)  return false;
        int target = sum >> 1;
        boolean[][] dp = new boolean[len +1 ][target + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if (nums[i-1] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i-1] < j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
                }
            }
            if (dp[i][target]) return true;
        }
        return dp[len][target];
    }
}
