package yang;

/**
 * @Description: 剑指 Offer 42. 连续子数组的最大和
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * @Author: yangchao
 * @Date: 2021/05/16/8:03b
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = Math.max(nums[0], 0);
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1],0) + nums[i];
            res = Math.max(dp[i],res);
        }
        return res;
    }
}
