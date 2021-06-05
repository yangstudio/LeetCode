package yang;

/**
 * @Description: 剑指 Offer 04. 二维数组中的查找
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * @Author: yangchao
 * @Date: 2021/04/13/8:16
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            //消除第i行元素【大于第i行的元素都比当前元素大】
            if (matrix[i][j] > target) i--;
            //消除第j列元素【小于第j列的元素都比当前元素小】
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }

    /*public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }*/
}
