package yang;

/**
 * @Description: 29.两数相除
 * https://leetcode-cn.com/problems/divide-two-integers/
 * @Author: yangchao
 * @Date: 2020/12/14/14:25
 */

public class Divide {
    public int divide(int dividend, int divisor) {
        if(divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE; // 溢出
        boolean neg = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        int res = 0;
        //除数和被除数都转换成负数，防止溢出
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);

        while (dividend <= divisor) {
            int tempDiv = divisor;
            int tempRes = 1;
            while (dividend <= tempDiv << 1) {
                tempDiv = tempDiv << 1;
                tempRes = tempRes << 1;
            }
            dividend -= tempDiv;
            res += tempRes;
        }
        return neg ? res : -res;
    }
}
