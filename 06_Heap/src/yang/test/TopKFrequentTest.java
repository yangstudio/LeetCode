package yang.test;

import org.junit.Test;
import yang.TopKFrequent;

import java.util.Arrays;


/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/12/01/9:35
 */
public class TopKFrequentTest {

    @Test
    public void topKFrequent() {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        TopKFrequent tf = new TopKFrequent();
        int[] res = tf.topKFrequent(nums,k);
        System.out.println(Arrays.toString(res));

    }
}