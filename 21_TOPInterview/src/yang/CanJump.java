package yang;

/**
 * @Description: 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 * @Author: yangchao
 * @Date: 2021/03/27/15:11
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 1) return true;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 1; i < len; i++) {
            for (int j = i-1; j >= 0; j--) {
                dp[i] = dp[j] && (nums[j] >= i-j);
                if (dp[i]) break;
            }
        }
        return dp[len-1];
    }
}
