package yang;

/**
 * @Description: 35. 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 * @Author: yangchao
 * @Date: 2020/12/04/8:35
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) return 0;
        if (target > nums[nums.length-1]) return nums.length;
        int left = 0;
        int right = nums.length - 1;
        int prevLess = left;

        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                prevLess = mid;
                left = mid + 1;
            }
        }
        return prevLess+1;
    }
}
