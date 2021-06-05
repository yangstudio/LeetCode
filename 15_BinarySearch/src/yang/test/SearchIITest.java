package yang.test;

import org.junit.Test;
import yang.SearchII;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/12/08/8:57
 */
public class SearchIITest {

    @Test
    public void search() {

        int[] nums = {1,3,1,1,1};
        int target = 3;

        SearchII se = new SearchII();
        boolean res = se.search(nums,target);
        System.out.println(res);

    }
}