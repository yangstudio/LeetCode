package yang.test;

import org.junit.Test;
import yang.Permute;

import java.util.List;

import static org.junit.Assert.*;

public class PermuteTest {

    @Test
    public void permute() {
        int[] nums = {1,2,3};
        Permute p = new Permute();
        List<List<Integer>> lists = p.permute(nums);
        System.out.println(lists);
    }
}