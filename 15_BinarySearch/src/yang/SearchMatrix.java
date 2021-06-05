package yang;

/**
 * @Description: 74. 搜索二维矩阵
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @Author: yangchao
 * @Date: 2020/12/11/8:15
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null||matrix.length == 0) return false;
        int n = matrix[0].length;
        for (int[] nums : matrix) {
            if (nums == null || nums.length == 0) continue;
            if (target >= nums[0] && target <= nums[n-1]) {
                int left = 0;
                int right =n-1;
                while(left <= right) {
                    int mid = (left + right) / 2;
                    if(nums[mid] == target) {
                        return true;
                    } else if ( nums[mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
