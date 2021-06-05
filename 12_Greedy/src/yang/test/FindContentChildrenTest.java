package yang.test;

import org.junit.Test;
import yang.FindContentChildren;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/11/24/16:00
 */
public class FindContentChildrenTest {

    @Test
    public void findContentChildren() {
        FindContentChildren fc = new FindContentChildren();
        int[] g = {1,2};
        int[] s = {1,2,3};
        int count = fc.findContentChildren(g,s);
        System.out.println(count);
    }
}