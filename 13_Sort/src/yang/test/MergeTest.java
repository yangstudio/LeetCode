package yang.test;

import org.junit.Test;
import yang.Merge;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/11/30/9:26
 */
public class MergeTest {

    @Test
    public void merge() {
        Merge me = new Merge();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals1 = {{2,3},{4,5},{6,7},{8,9},{1,10}};

        int[][] results = me.merge(intervals1);
        for (int[] result : results) {
            System.out.println(Arrays.toString(result));
        }
    }
}