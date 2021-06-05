package yang;

/**
 * @Description: 152. 乘积最大子数组
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * @Author: yangchao
 * @Date: 2021/03/27/9:12
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            //dp[i][0]:表示以第i个元素结尾的子数组的乘积的最大值；
            //dp[i][1]:表示以第i个元素结尾的子数组的乘积的最小值；
            dp[i][0] = Math.max(dp[i-1][1]*nums[i],Math.max(dp[i-1][0]*nums[i],nums[i]));
            dp[i][1] = Math.min(dp[i-1][0]*nums[i],Math.min(dp[i-1][1]*nums[i],nums[i]));
            res = Math.max(res,dp[i][0]);
        }
        return res;
    }
}
