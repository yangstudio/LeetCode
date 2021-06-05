package yang;

/**
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 */
public class Jump {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return true;
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && nums[j] >= i-j) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len-1];
    }
}
