package yang;

import java.util.Arrays;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/11/24/17:43
 */
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points,(p1,p2)-> p1[1] < p2[1] ? -1 : 1);
        int pos = points[0][1];
        int res = 1;
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                res++;
            }
        }
        return res;
    }
}
