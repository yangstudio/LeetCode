package yang;

/**
 * @Description: 11. 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 * @Author: yangchao
 * @Date: 2021/01/06/9:02
 */
public class MaxArea {
    public int maxArea(int[] height) {
        //双指针夹逼，那边的板子短就往那边移动！
        int left = 0, right = height.length - 1;
        int res = 0;
        while(left < right) {
            int area = Math.min(height[left],height[right]) * (right - left);
            res = Math.max(area,res);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
