package yang;

import java.util.Arrays;

/**
 * @Description: 剑指 Offer 03. 数组中重复的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @Author: yangchao
 * @Date: 2021/04/13/8:10
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        int pre = nums[0];
        for (int i = 1; i < nums.length;i++) {
            if (nums[i] == pre) return pre;
            pre = nums[i];
        }
        return -1;
    }
}
