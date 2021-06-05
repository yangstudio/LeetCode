package yang;

/**
 * @Description: 416. 分割等和子集
 * @Author: yangchao
 * @Date: 2021/03/23/8:46
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //如果数组和为奇数，不符合要求
        if ((sum & 1) == 1) return false;
        int tar = sum >> 1;
        //dp[i][j] 表示从数组的i个元素(索引为0~i-1)中，挑选一些元素，每个数只能取一次，使得这些数的和恰好等于j
        boolean[][] dp = new boolean[len+1][tar+1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= tar; j++) {
                //直接把结果从上一行抄下来，然后再做修正
                dp[i][j] = dp[i-1][j];
                if (nums[i-1] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i-1] < j) {
                    //不选择 nums[i]，如果在 [0, i - 1] 这个子区间内已经有一部分元素，使得它们的和为 j ，那么 dp[i][j] = true；
                    //选择 nums[i]，如果在 [0, i - 1] 这个子区间内就得找到一部分元素，使得它们的和为 j - nums[i]
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
            if (dp[i][tar]) return true;
        }
        return dp[len][tar];
    }

    //考虑空间优化
    public boolean canPartitionII(int[] nums) {
        int len = nums.length;
        if (len == 0) return false;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if ((sum & 1) == 1) return false;
        int tar = sum >> 1;
        boolean[] dp = new boolean[tar+1];
        //dp[j-nums[i-1]]用到了dp[0]，当j == nums[i-1]时，显然为true；
        dp[0] = true;
        for (int num : nums) {
            for (int i = tar; i >= num; i--) {
                if (dp[tar]) return true;
                dp[i] = dp[i] || dp[i- num];
            }
        }
        return dp[tar];
    }
}
