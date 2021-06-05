package yang;

/**
 * @Description: 189. 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 * @Author: yangchao
 * @Date: 2021/01/08/9:02
 */
public class Rotate {
    /**
     * 要求空间复杂度为O(1)，时间复杂度为 O(n)
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k %= nums.length;
        reversal(nums,0,nums.length-1);
        reversal(nums,0,k-1);
        reversal(nums,k,nums.length-1);

    }
    private void reversal(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }
}
