package yang;

import java.util.Arrays;

/**
 * @Description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @Author: yangchao
 * @Date: 2020/12/04/14:26
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res,-1);

        int index = 0;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid]  == target) {
                for (int i = left; i <= right; i++) {
                    if (nums[i] == target) {
                        if (index == 0) {
                            res[0] = i;
                            index = 1;
                            res[1] = i;
                        } else {
                            res[1] = i;
                        }
                    }
                }
                return res;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
