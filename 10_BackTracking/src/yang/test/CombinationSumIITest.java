package yang.test;

import org.junit.Test;
import yang.CombinationSum;
import yang.CombinationSumII;

import java.util.List;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/11/19/14:29
 */
public class CombinationSumIITest {

    @Test
    public void combinationSum2() {
        /*int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;*/
        int[] candidates = {2,5,2,1,2};
        int target = 5;
        CombinationSumII sum = new CombinationSumII();
        List<List<Integer>> lists = sum.combinationSum2(candidates,target);
        System.out.println(lists);
    }
}