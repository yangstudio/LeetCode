package yang;

/**
 * @Description: 剑指 Offer 57. 和为s的两个数字
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * @Author: yangchao
 * @Date: 2021/06/01/8:04
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s < target) i++;
            else if (s > target) j--;
            else return new int[]{nums[i],nums[j]};
        }
        return new int[0];
    }
}
