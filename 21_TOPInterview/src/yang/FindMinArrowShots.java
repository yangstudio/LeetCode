package yang;

import java.util.Arrays;

/**
 * @Description: 452. 用最少数量的箭引爆气球
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * @Author: yangchao
 * @Date: 2021/04/04/15:41
 */
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points,(p1,p2) -> p1[1] < p2[1] ? -1 : 1);
        int res = 1;
        int pre = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > pre) {
                res++;
                pre = points[i][1];
            }
        }
        return res;
    }
}
