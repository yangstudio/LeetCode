package yang.test;

import org.junit.Test;
import yang.MyPow;


/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/12/11/14:50
 */
public class MyPowTest {

    @Test
    public void myPow() {
        MyPow mp = new MyPow();
        double x = 2;
        int n = 5;
        double res = mp.myPow(2,5);
        System.out.println(res);
    }
}