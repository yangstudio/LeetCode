package yang;

import java.util.Arrays;

/**
 * @Description: 16. 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/
 * @Author: yangchao
 * @Date: 2021/01/07/9:00
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int left = i + 1, right = len - 1;
            while (left < right) {
               int sum = nums[i] + nums[left] + nums[right];
               if (Math.abs(sum - target) < Math.abs(ans - target)) {
                   ans = sum;
               }
               if (sum < target) {
                   left++;
               } else if ( sum > target){
                   right--;
               } else {
                   return ans;
               }
            }
        }
        return ans;
    }
}
