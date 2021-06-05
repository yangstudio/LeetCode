package yang;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Description: 628. 三个数的最大乘积
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 * @Author: yangchao
 * @Date: 2021/01/20/8:41
 */
public class MaximumProduct {
    /**
     * 排序
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[0]*nums[1]*nums[len-1],nums[len-3]*nums[len-2]*nums[len-1]);
    }

    /**只要求出数组中最大的三个数和最小的两个数
     * 线性扫描
     */
    public int maximumProductII(int[] nums){
        int min1 = Integer.MAX_VALUE;
        int min2 = min1;
        int max1 = Integer.MIN_VALUE;
        int max2 = max1, max3 = max1;

        for (int num : nums) {
            if (num < min1) {
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
            if (num > max1) {
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return Math.max(min1*min2*max1,max1*max2*max3);
    }
}
