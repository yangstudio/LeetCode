package yang;

import java.util.List;

/**
 * @Description: 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 * @Author: yangchao
 * @Date: 2021/03/24/14:34
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len == 1) return triangle.get(0).get(0);
        int[][] dp = new int[len][len];
        dp[0][0] = triangle.get(0).get(0);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {         //每一行第一个元素只有一种情况
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                } else if (j == i) {  //每一行最后一个元素只有一种情况
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle.get(i).get(j);
                }
                if (i == len-1) {
                    res = Math.min(res,dp[len-1][j]);
                }
            }
        }
        return res;
    }
    //考虑空间优化
    public int minimumTotalII (List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len == 1) return triangle.get(0).get(0);
        int[] dp = new int[len];
        dp[0] = triangle.get(0).get(0);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            //每行最后一个元素只有一种情况
            dp[i] = dp[i-1] + triangle.get(i).get(i);
            if (i == len - 1) res = dp[i];
            for (int j = i-1; j > 0; j--){
                dp[j] = Math.min(dp[j],dp[j-1]) + triangle.get(i).get(j);
                if (i == len-1) {
                    res = Math.min(res,dp[j]);
                }
            }
            dp[0] = dp[0] + triangle.get(i).get(0);
            if (i == len -1 ) res = Math.min(res,dp[0]);
        }
        return res;
    }
}
