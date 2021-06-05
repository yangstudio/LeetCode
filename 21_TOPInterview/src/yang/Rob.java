package yang;

/**
 * @Description: 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * @Author: yangchao
 * @Date: 2021/03/26/14:54
 */
public class Rob {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len < 2) return len == 0 ? 0 : nums[0];
        //dp[i] : 偷盗前 i 家时，最多能偷到的金额
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[len-1];
    }
}
