package yang;

/**
 * @Description:169. 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 * @Author: yangchao
 * @Date: 2020/11/23/14:10
 */
public class MajorityElement {
    //[2,2,1,1,1,2,2]; [3,2,3]
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int countInRange(int[] nums,int num,int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
    private int majorityElementRec(int[] nums, int lo, int hi) {
        if (lo == hi) return nums[lo];
        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);
        // if the two halves agree on the majority element, return it.
        if (left == right) return left;
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }
}

