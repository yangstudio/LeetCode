package yang;

import java.util.Arrays;

/**
 * @Description:435. 无重叠区间
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 * @Author: yangchao
 * @Date: 2020/11/25/8:41
 */
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (i1, i2) -> i1[1] < i2[1] ? -1 : 1);
        int nolapp = 1;
        int pos = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] >= pos) {
                nolapp++;
                pos = interval[1];
            }
        }
        return intervals.length - nolapp;
    }
}
