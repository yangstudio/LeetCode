package yang;

import org.junit.Test;

/**
 * @Description: 4. 寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @Author: yangchao
 * @Date: 2021/04/11/9:48
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int toLen = len1 + len2;
        if (toLen % 2 == 1) {
            int midIndex = toLen/2;
            double median = getKthElement(nums1,nums2,midIndex+1);
            return median;
        } else {
            int midIndex1 = toLen/2 - 1, midIndex2 = toLen/2;
            double median = (double)(getKthElement(nums1,nums2,midIndex1+1) + getKthElement(nums1,nums2,midIndex2+1))/2.0;
            return median;
        }
    }

    private int getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;
        int KthElement = 0;
        while (true) {
            //边界情况
            if (index1 == len1) {
                return nums2[index2+k-1];
            }
            if (index2 == len2) {
                return nums1[index1+k-1];
            }
            if (k == 1) {
                return Math.min(nums1[index1],nums2[index2]);
            }
            //正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1+half,len1) - 1;
            int newIndex2 = Math.min(index2+half,len2) - 1;
            int privot1 = nums1[newIndex1], privot2 = nums2[newIndex2];
            if (privot1 <= privot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    @Test
    public void findMedianSortedArraysTest() {
        int[] nums1 = new int[] {1,3,4,9};
        int[] nums2 = new int[] {1,2,3,4,5,6,7,8,9};
        FindMedianSortedArrays fsa = new FindMedianSortedArrays();
        double res = fsa.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);

    }
}
