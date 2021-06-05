package yang;

/**
 * @Description: 213. 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii/
 * @Author: yangchao
 * @Date: 2021/03/26/15:12
 */
public class RobII {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len < 2) return len == 0 ? 0 : nums[0];
        int[][] dp = new int[len][2];
        dp[1][0] = nums[0];
        dp[1][1] = nums[1];
        for (int i = 2; i < len; i++) {
            //去掉最后一个元素
            dp[i][0] = Math.max(dp[i-1][0],dp[i-2][0]+nums[i-1]);
            //去掉第一个元素
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][1]+nums[i]);
        }

        return Math.max(dp[len-1][0],dp[len-1][1]);
    }
}
