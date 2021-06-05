package yang;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description: 57. 插入区间
 *https://leetcode-cn.com/problems/insert-interval/
 * @Author: yangchao
 * @Date: 2021/04/03/16:17
 */
public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        if (len == 0) return new int[][]{newInterval};
        int[][] res = new int[len+1][2];
        int index = 0;
        //1. 遍历区间列表：首先将新区建左边且乡里的区间加入结果集
        int i = 0;
        while (i < len && intervals[i][1] < newInterval[0]) {
            res[index++] = intervals[i++];
        }
        //2.判断当前区间是否与新区间重叠，如果重叠，即进行合并，
        // 直到遍历到当前区间在新区建的右边且相离，将最终合并后的新区建加入结果集
        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res[index++] = newInterval;
        //最后将新区间右边且相离的区间加入结果集
        while (i < len) {
            res[index++] = intervals[i++];
        }
        return Arrays.copyOf(res,index);
    }

    @Test
    public void insertTest(){
        int[][] intervals = new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = new int[] {4,8};
        Insert is = new Insert();
        int[][] arrs = is.insert(intervals, newInterval);
        for (int[] arr :arrs) {
            System.out.println("================");
            for (int val : arr) {
                System.out.println(val);
            }
        }
    }

}
