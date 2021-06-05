package yang;

/**
 * @Description: 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * @Author: yangchao
 * @Date: 2021/03/29/11:06
 */
public class FindMin {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int left = 0, right = len-1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                //因为中值 < 右值，但中值也可能是最小值，右边界只能取到mid处
                // 例如：【5,6,7,0,1,2,4】
                right = mid;
            }
        }
        return nums[left];
    }
}
