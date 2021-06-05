package yang;

import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class RobII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    //单排排列
    private int myRob(int[] nums) {
        int prev = 0,curr = 0;
        //每次循环，计算“偷到当前房子为止的最大金额”
        for (int num : nums) {
            //循环开始时，curr表示dp[k-1], prev表示dp[k-2]
            //dp[k] = max(dp[k-1],dp[k-2]+num);
            int temp = Math.max(curr,prev+num);
            prev = curr;
            curr = temp;
            //循环结束时，curr表示dp[k],prev表示dp[k-1]
        }
        return curr;
    }
}
