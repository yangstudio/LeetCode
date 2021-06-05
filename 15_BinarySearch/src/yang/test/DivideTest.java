package yang.test;

import org.junit.Test;
import yang.Divide;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/12/14/14:37
 */
public class DivideTest {

    @Test
    public void divide() {
        Divide d = new Divide();
        int dividend = 43;
        int divisor = 2;
        int res = d.divide(dividend,divisor);
        System.out.println(res);
    }

    @Test
    public void test() {
        int a = -2147483648;
        a = -Math.abs(a);
        System.out.println(a);
    }
}