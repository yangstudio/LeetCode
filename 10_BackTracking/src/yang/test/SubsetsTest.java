package yang.test;

import org.junit.Test;
import yang.Subsets;

import java.util.List;

import static org.junit.Assert.*;

public class SubsetsTest {

    @Test
    public void subsets() {
        int[] nums = {1,2,3};
        Subsets sub = new Subsets();
        List<List<Integer>> lists = sub.subsets(nums);
        System.out.println(lists);
    }
}