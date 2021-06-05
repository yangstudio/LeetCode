package yang;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LengthOfLIS {
    //动态规划
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = 1;
        Arrays.fill(dp,1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j] +1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

}
