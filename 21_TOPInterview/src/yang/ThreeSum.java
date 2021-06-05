package yang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * @Author: yangchao
 * @Date: 2021/03/21/17:44
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) return lists;
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len-2; i++) {
            //如果当前元素大于0，则三数之和一定大于0，直接结束循环
            if (nums[i] > 0) break;
            //本轮和上一轮重复，则跳过本次循环
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i+1, right = len-1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return lists;
    }
}
