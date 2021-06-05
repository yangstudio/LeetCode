package yang.test;

import org.junit.Test;
import yang.Rotate;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/01/08/9:16
 */
public class RotateTest {
    @Test
    public void test01(){
        int[] nums = new int[] {1,2,3,4,5,6,7};
        int k = 3;
        Rotate rt = new Rotate();
        rt.rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }

}