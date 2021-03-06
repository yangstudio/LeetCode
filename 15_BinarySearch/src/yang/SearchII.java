package yang;

/**
 * @Description: 81. 搜索旋转排序数组 II
 * 本题中的 nums 可能包含重复元素。
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 * @Author: yangchao
 * @Date: 2020/12/08/8:36
 */
public class SearchII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0, right = nums.length - 1, mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[left]) {
                left++;
                continue;
            }
            if (nums[mid] > nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
