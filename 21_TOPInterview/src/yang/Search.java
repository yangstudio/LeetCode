package yang;

/**
 * @Description: 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @Author: yangchao
 * @Date: 2021/03/29/9:50
 */
public class Search {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len-1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) return mid;
            //先根据nums[mid]与nums[left]的关系判断mid是在左边还是右边
            //为什么这里会有等于号呢？因为我们在算mid时是向下取整的，例如left=4，right=5，则mid=(4+5)/2 = 4
            if (nums[mid] >= nums[left]) { //【left，mid】有序
            //再判断target是在mid的左边还是右边，从而调整左右边界left和right
                if (target >= nums[left] && target < nums[mid]) { //这一范围内可以确定是有序的
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {  //【mid，right】有序
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
