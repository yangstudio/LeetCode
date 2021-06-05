package yang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 350. 两个数组的交集 II
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * @Author: yangchao
 * @Date: 2020/12/03/14:48
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[]{};
        int len = nums1.length;
        List<Integer> lsit = new ArrayList<>();
        int[] res = new int[len];
        int index = 0, i1 = 0, i2 = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while(i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] < nums2[i2]) {
                i1++;
            } else if (nums1[i1] > nums2[i2]) {
                i2++;
            } else {
                res[index] = nums1[i1];
                index++;
                i1++;
                i2++;
            }
        }
        return Arrays.copyOf(res,index);
    }
}
