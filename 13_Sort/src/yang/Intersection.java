package yang;

import java.util.Arrays;

/**
 * @Description: 349. 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @Author: yangchao
 * @Date: 2020/12/03/14:22
 */

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
       if (nums1 == null || nums2 == null) return new int[]{};
       int len = nums1.length;
       int[] res = new int[len];
       int prev = Integer.MAX_VALUE;  //不能写成0，可能数组的第一个元素就是0
       int index = 0, i1 = 0, i2 = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while(i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] < nums2[i2]) {
                i1++;
            } else if (nums1[i1] > nums2[i2]) {
                i2++;
            } else {
                if (nums1[i1] != prev) {
                    res[index] = nums1[i1];
                    prev = res[index];
                    index++;
                }
                i1++;
                i2++;
            }
        }
        return Arrays.copyOf(res,index);
    }
}
