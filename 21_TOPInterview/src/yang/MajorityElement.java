package yang;

import java.util.Arrays;

/**
 * @Description: 169. 多数元素
 * 时间复杂度为 O(n)、空间复杂度为 O(1)
 * https://leetcode-cn.com/problems/majority-element/
 * @Author: yangchao
 * @Date: 2021/04/06/14:49
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums); //排序后时间复杂度不满足要求
        int k = nums.length >> 1;
        return nums[k];
    }

    //摩尔投票算法
    public int majorityElement1(int[] nums) {
        int candNum = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (candNum == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candNum = nums[i];
                    count = 1;
                }
            }
        }
        return candNum;
    }

}
