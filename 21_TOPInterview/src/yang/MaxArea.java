package yang;

import sun.misc.Unsafe;

/**
 * @Description: 11. 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 * @Author: yangchao
 * @Date: 2021/03/02/9:03
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            res = Math.max(Math.min(height[left],height[right])*(right-left),res);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
