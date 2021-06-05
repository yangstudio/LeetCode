package yang;

/**
 * @Description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @Author: yangchao
 * @Date: 2021/03/28/13:08
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1,-1};
        int len = nums.length;
        if (len == 0 || nums[0] > target || nums[len-1] < target) {
            return res;
        }

        //寻找起始位置
        int left = 0;
        int right = len-1;
        while (left < right) {
            //此处mid的计算采用了向下取整的方式
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                //小于一定不是解
                left = mid + 1;
            } else if (nums[mid] == target) {
                //下一轮搜索区间是[left,mid]
                right = mid;
            } else {
                //nums[mid] > target,下一轮的搜索区间是[left,mid-1]
                right = mid - 1;
            }
        }
        if (nums[left] != target) return res;
        res[0] = left;

        //寻找结束位置
        right = len-1;
        while (left < right) {
            //此处mid的计算采用了向上取整的方式
            int mid = (left + right + 1) >> 1;
            if (nums[mid] > target) {
                //下一轮的搜索区间是[left,mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                //下一轮的搜索区间是[mid,right]
                left = mid;
            } else {
                //nums[mid] < target, 下一轮的搜索区间是[mid+1,right]
                left = mid + 1;
            }
        }
        if (nums[right] == target) {
            res[1] = right;
        }
        return res;
    }
}
