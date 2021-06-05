package yang.test;

import org.junit.Test;
import yang.RemoveStones;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/01/15/9:56
 */
public class RemoveStonesTest {

    @Test
    public void removeStones() {
        int[][] stones = new int[][] {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        RemoveStones rs = new RemoveStones();
        int res = rs.removeStones(stones);
        System.out.println(res);
    }
}