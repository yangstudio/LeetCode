package yang;

/**
 * 152. 乘积最大子数组
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] mindp = new int[len];
        int[] maxdp = new int[len];
        System.arraycopy(nums,0,maxdp,0,nums.length);
        System.arraycopy(nums,0,mindp,0,nums.length);
        int product = maxdp[0];

        for (int i = 1; i < nums.length; i++) {
            maxdp[i] = Math.max(maxdp[i-1]*nums[i],Math.max(mindp[i-1]*nums[i],nums[i]));
            mindp[i] = Math.min(mindp[i-1]*nums[i],Math.min(maxdp[i-1]*nums[i],nums[i]));
            product = Math.max(product,maxdp[i]);
        }
        return product;
    }
}
