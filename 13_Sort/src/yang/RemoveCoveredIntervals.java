package yang;

import java.util.Arrays;

/**
 * @Description: 1288. 删除被覆盖区间
 * https://leetcode-cn.com/problems/remove-covered-intervals/
 * @Author: yangchao
 * @Date: 2020/12/01/15:33
 */
public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(m,n) -> m[0] != n[0] ? m[0]-n[0] : n[1]-m[1]);

        int res = 0;
        int right = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] <= right) {
                res++;
            } else {
                right = intervals[i][1];
            }
        }
        return intervals.length - res;
    }
}
