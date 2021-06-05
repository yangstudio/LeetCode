package yang.test;

import org.junit.Test;
import yang.Search;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/12/07/8:57
 */
public class SearchTest {

    @Test
    public void search() {
        /*int[] nums = {4,5,6,7,0,1,2};
        int target = 0;*/

        /*//主程序第20行需要等号，不然这个用例测试不通过
        int[] nums = {3,1};
        int target = 1;*/

        int[] nums = {6,7,0,1,2,3,4,5};
        int target = 6;

        Search se = new Search();
        int search = se.search(nums, target);
        System.out.println(search);
    }
}