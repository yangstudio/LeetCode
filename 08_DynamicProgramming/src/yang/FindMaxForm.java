package yang;

/**
 * 474. 一和零
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 */
public class FindMaxForm {
    /**
     * 二维数组优化
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int strNums = strs.length;
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= strNums; i++) {
            int[] cnt = countZeroAndOne(strs[i-1]);
            for (int j = m; j >= cnt[0]; j--) {
                for (int k = n; k >=cnt[1]; k--){
                    dp[j][k] = Math.max(dp[j][k],dp[j-cnt[0]][k-cnt[1]]+1);
                }
            }
        }
        return dp[m][n];
    }

    public int findMaxForm1(String[] strs, int m, int n) {
        int strNums = strs.length;
        int[][][] dp = new int[strNums+1][m+1][n+1];

        for (int i = 1; i <= strNums; i++) {
            int[] cnt = countZeroAndOne(strs[i-1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++){
                    if (cnt[0] > j || cnt[1] > k) {
                        dp[i][j][k] = dp[i-1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j-cnt[0]][k-cnt[1]]+1);
                    }
                }
            }
        }
        return dp[strNums][m][n];
    }
    /**
     * 统计每个字符串中0和1的个数
     * cnt[0] = zeroNums, cnt[1] = oneNums
     * @param s
     * @return
     */
    private int[] countZeroAndOne(String s) {
        int[] count = new int[2];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'0']++;
        }
        return count;
    }

}
