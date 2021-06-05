package yang;

import java.util.Arrays;

/**
 * @Description: 435. 无重叠区间
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 * https://leetcode-cn.com/problems/non-overlapping-intervals/solution/tan-xin-suan-fa-zhi-qu-jian-diao-du-wen-ti-by-labu/
 * @Author: yangchao
 * @Date: 2021/04/06/8:32
 */
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return 0;
        Arrays.sort(intervals,(i1,i2) -> i1[1] < i2[1] ? -1 : 1);
        //至少有一个区间不相交
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
