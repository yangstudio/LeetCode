package yang;

/**
 * 718. 最长重复子数组
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 */
public class LongestCommonSubsarray {
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null ||
            A.length == 0 || B.length == 0) return 0;
        int[] rows = A, cols = B;
        if (A.length < B.length) {
            cols = A;
            rows = B;
        }

        int[] dp = new int[cols.length + 1];
        int max = 0;
        for (int row = 1; row <= rows.length; row++) {
            int cur = 0;
            for (int col = 1; col <= cols.length; col++) {
                int leftTop = cur;
                cur = dp[col];
                if (rows[row-1] != cols[col-1]) {
                    dp[col] = 0;
                } else {
                    dp[col] = leftTop + 1;
                    max = Math.max(dp[col],max);
                }
            }
        }
        return max;
    }
}
