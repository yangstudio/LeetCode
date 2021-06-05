package yang.test;

import org.junit.Test;
import yang.CombinationSum;

import java.util.List;

public class combinationSumTest {

    @Test
    public void combinationSum() {
        int[] candidates = {2,3,6,7};
        int target = 7;
        CombinationSum sum = new CombinationSum();
        List<List<Integer>> lists = sum.combinationSum(candidates,target);
        System.out.println(lists);
    }
}