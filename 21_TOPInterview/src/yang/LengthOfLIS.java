package yang;

import java.util.Arrays;

/**
 * @Description: 300. 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @Author: yangchao
 * @Date: 2021/03/22/14:45
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int len = nums.length;
        //dp[i] : 表示以nums[i]结尾的递增子序列的最大长度
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
