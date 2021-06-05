package yang;

import java.util.Arrays;

/**
 * @Description: 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @Author: yangchao
 * @Date: 2020/12/07/8:38
 */
public class Search {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左子数组还是右子数组
            if (nums[mid] >= nums[left]) {
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
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
        return -1;
    }

   /* public int search1(int[] nums, int target) {
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                start = i;
            }
        }
        int[] array = new int[nums.length];
        System.arraycopy(nums,start,array,0,nums.length - start);
        System.arraycopy(nums,0,array,nums.length - start,start);

        System.out.println(Arrays.toString(array));
        System.out.println(start);

        int left = 0;
        int right = array.length-1;
        while(left <= right) {
            int mid = (left + right)/2;
            if (array[mid] == target) {
                int resLen = array.length - start;
                if (mid >= resLen) {
                    return mid - resLen;
                } else {
                    return mid + start;
                }
            } else if (array[mid] > target) {
                right = mid -1;
            } else {
                left = mid + 1;
            }

        }
        return -1;
    }*/
}
