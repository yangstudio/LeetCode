package yang.test;

import org.junit.Test;
import yang.CanPlaceFlowers;


/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/11/25/14:35
 */
public class CanPlaceFlowersTest {

    @Test
    public void canPlaceFlowers() {
        int[] flowerbed = {1,0,0,0,1};
        int n = 1;
        CanPlaceFlowers cf = new CanPlaceFlowers();
        boolean res = cf.canPlaceFlowers(flowerbed,n);
        System.out.println(res);
    }
}