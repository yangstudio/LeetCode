package yang.test;

import org.junit.Test;
import yang.MaxSlidingWindow;

import java.util.Arrays;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/12/15/15:45
 */
public class MaxSlidingWindowTest {

    @Test
    public void maxSlidingWindow() {
        MaxSlidingWindow msw = new MaxSlidingWindow();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = msw.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}