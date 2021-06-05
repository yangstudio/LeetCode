package yang;

import java.util.Arrays;

/**
 * @Description: 349. 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 * @Author: yangchao
 * @Date: 2021/04/04/9:31
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        int len1 = nums1.length, len2 = nums2.length;
        int[] res = new int[Math.max(len1,len2)];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int index = 0;
        while(i < len1 && j < len2) {
            int val1 = nums1[i];
            int val2 = nums2[j];
            if (val1 == val2) {
                if (index == 0 || val1 != res[index-1]) {
                    res[index++] = val1;
                }
                i++;
                j++;
            } else if (val1 < val2) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOf(res,index);
    }
}
