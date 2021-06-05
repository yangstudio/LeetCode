package yang.test;

import org.junit.Test;
import yang.PermuteUnique;

import java.util.List;

import static org.junit.Assert.*;

public class PermuteUniqueTest {

    @Test
    public void permuteUnique() {
        int[] nums = {1,2,1};
        PermuteUnique pu = new PermuteUnique();
        List<List<Integer>> lists = pu.permuteUnique(nums);
        System.out.println(lists);
    }
}