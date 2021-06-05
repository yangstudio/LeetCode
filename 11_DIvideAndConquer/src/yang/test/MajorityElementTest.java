package yang.test;

import org.junit.jupiter.api.Test;
import yang.MajorityElement;


/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/11/23/14:53
 */
public class MajorityElementTest {

    @Test
    public void majorityElement() {
        int[] nums = {2,2,1,1,1,2,2};
        MajorityElement me = new MajorityElement();
        int major = me.majorityElement(nums);
        System.out.println(major);
    }
}