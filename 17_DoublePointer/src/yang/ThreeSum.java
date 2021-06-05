package yang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * @Author: yangchao
 * @Date: 2021/01/06/15:09
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) return lists;
        Arrays.sort(nums); //排序
        int len = nums.length;

        for (int i = 0; i < len-2; i++) {
            //如果当前元素大于0，则三数之和一定大于0，直接结束循环
            if (nums[i] > 0) break;
            //本轮和上一轮重复
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //去重: 现在要增加 left，减小 right，但是不能重复，
                    // 比如: [-2, -1, -1, -1, 3, 3, 3], nums[i] = -2, left = 1, right = 6,
                    // [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    while (left < right && nums[left] == nums[left+1]) left++;      //去重
                    while (left < right && nums[right] == nums[right-1]) right--;   //去重
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
