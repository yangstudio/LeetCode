package yang;

import java.util.Arrays;

/**
 * @Description: 56. 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 * @Author: yangchao
 * @Date: 2021/04/03/15:30
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 1) return intervals;
        //每个区间按照区间的起始位置升序排序
        Arrays.sort(intervals,(arr1,arr2) -> arr1[0] - arr2[0]);
        int[][] res = new int[len][2];
        int[] prev = intervals[0];
        int index = 0;
        for (int i = 1; i < len; i++) {
            int[] part = intervals[i];
            if (part[0] <= prev[1]) {
                //例如：[[1,4],[2,3]]，合并后区间的结束位置应该为max(4,3)
                prev[1] = Math.max(prev[1],part[1]);
                continue;
            }
            res[index++] = prev;
            prev = part;
        }
        res[index] = prev;
        return Arrays.copyOf(res,index+1);
    }
}
