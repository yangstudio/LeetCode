package yang;

import java.util.Arrays;

/**
 * @Description: 57. 插入区间
 * https://leetcode-cn.com/problems/insert-interval/
 * @Author: yangchao
 * @Date: 2020/12/02/14:42
 */
public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) return new int[][]{newInterval};
        int[][] res = new int[intervals.length + 1][2];
        int index = 0, i = 0;
        while( i < intervals.length && intervals[i][1] < newInterval[0]) {
            res[index++] = intervals[i++];
        }
        if (i < intervals.length) {
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
        }
        // 接着判断当前区间是否与新区间重叠，重叠的话就进行合并，直到遍历到当前区间在新区间的右边且相离
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        res[index++] = newInterval;
        while(i < intervals.length) {
            res[index++] = intervals[i++];
        }
        return Arrays.copyOf(res,index);
    }
}
