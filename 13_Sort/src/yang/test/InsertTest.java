package yang.test;

import org.junit.Test;
import yang.Insert;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/12/02/15:07
 */
public class InsertTest {

    @Test
    public void insert() {
        /*int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};*/

        /*int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};*/

        int[][] intervals = {{1,5}};
        int[] newInterval = {6,8};

        int len = intervals.length;
        boolean ans = intervals == null;

        Insert i = new Insert();
        int[][] res = i.insert(intervals,newInterval);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }

    }
}