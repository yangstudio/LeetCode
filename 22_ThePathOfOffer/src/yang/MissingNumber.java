package yang;

/**
 * @Description: 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 * @Author: yangchao
 * @Date: 2021/05/26/14:53
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length-1;
        while(i <= j) {
            int mid = (i +j) / 2;
            if (nums[mid] == mid) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}
