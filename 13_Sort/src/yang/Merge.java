package yang;

import java.util.Arrays;

/**
 * @Description: 56. 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 * @Author: yangchao
 * @Date: 2020/11/30/8:34
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(i1,i2)-> i1[0] > i2[0] ? 1 : -1 );
        int[][] result = new int[intervals.length][2];
        int index = -1;
        for (int[] interval : intervals) {
            if (index == -1 || interval[0] > result[index][1]) {
                result[++index] = interval;
            } else {
                //取右区间最大的一个
                result[index][1] = Math.max(result[index][1],interval[1]);
            }
        }
        return Arrays.copyOf(result,index+1);
    }
}
