package yang;

/**
 * @Description: 209. 长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * @Author: yangchao
 * @Date: 2020/12/09/8:57
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            right++;
            while (sum >= s) {
                len = Math.min(len,right - left);
                sum -= nums[left];
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
