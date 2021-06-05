package yang.test;

import org.junit.Test;
import yang.RemoveCoveredIntervals;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/12/02/8:44
 */
public class RemoveCoveredIntervalsTest {

    @Test
    public void removeCoveredIntervals() {
        int[][] intervals = {{1,2},{1,4},{3,4}};

        RemoveCoveredIntervals rcil = new RemoveCoveredIntervals();
        int i = rcil.removeCoveredIntervals(intervals);
        System.out.println(i);
    }
}