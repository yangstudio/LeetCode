package yang.test;

import org.junit.Test;
import yang.MySqrt;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/12/14/8:57
 */
public class MySqrtTest {

    @Test
    public void mySqrt() {
        MySqrt ms = new MySqrt();
        int res = ms.mySqrt(10);
        System.out.println(res);
    }
}