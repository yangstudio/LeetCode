package yang;

import java.util.List;

/**
 *120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 */
public class MinimumTotal {
    /**
     * 空间优化
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];
        dp[0] = triangle.get(0).get(0);
        int minRoute = dp[0];
        for (int i = 1; i < triangle.size(); i++) {
            //每行最后一个元素的路径只有一种情况
            dp[i] = dp[i-1] +  triangle.get(i).get(i);
            minRoute = dp[i];
            for (int j = i-1; j > 0; j--) {
                dp[j] = Math.min(dp[j],dp[j-1]) + triangle.get(i).get(j);
                minRoute = Math.min(minRoute,dp[j]);
            }
            //每行第一个元素的路径只有一种情况
            dp[0] = dp[0] + triangle.get(i).get(0);
            minRoute = Math.min(minRoute,dp[0]);;
        }
        return minRoute;
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];
        dp[0][0] = triangle.get(0).get(0);
        int minRoute = dp[0][0];
        for (int i = 1; i < triangle.size(); i++) {
            //每行第一个元素的路径只有一种情况
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            minRoute = dp[i][0];
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + triangle.get(i).get(j);
                minRoute = Math.min(minRoute,dp[i][j]);
            }
            //每行最后一个元素的路径只有一种情况
            dp[i][i] = dp[i-1][i-1] +  triangle.get(i).get(i);
            minRoute = Math.min(minRoute,dp[i][i]);
        }
        return minRoute;
    }
}
