package yang;

/**
 * @Description: 26. 删除排序数组中的重复项 要求：O(1)
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @Author: yangchao
 * @Date: 2021/01/12/14:23
 */

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int index = 0, p = 0;
        while (p < len) {
            nums[index] = nums[p];
            while (p < len-1 && nums[p] == nums[p+1]) {
                p++;
            }
            index++;
            p++;
        }
        return index;
    }
}



