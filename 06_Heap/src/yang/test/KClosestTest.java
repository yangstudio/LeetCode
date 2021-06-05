package yang.test;

import org.junit.Test;
import yang.KClosest;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/12/01/14:44
 */
public class KClosestTest {

    @Test
    public void kClosest() {
        int[][] points = {{-5,4},{-6,-5},{4,6},{1,2},{1,1}};
        int K = 2;
        KClosest kc = new KClosest();
        int[][] res = kc.kClosest(points, K);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }
}