package yang.test;

import org.junit.Test;
import yang.Subsets;
import yang.SubsetsWithDup;

import java.util.List;

import static org.junit.Assert.*;

public class SubsetsWithDupTest {

    @Test
    public void subsetsWithDup() {
        int[] nums = {1,2,2};
        SubsetsWithDup sub = new SubsetsWithDup();
        List<List<Integer>> lists = sub.subsetsWithDup(nums);
        System.out.println(lists);
    }
}