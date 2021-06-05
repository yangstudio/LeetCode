package yang;

/**
 * @Description: 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 * @Author: yangchao
 * @Date: 2020/12/11/14:06
 */
public class MyPow {
    public double myPow(double x, int n) {
        if (x == 0.0f) return 0.0d;
        if (n == 0) return 1;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1/x;
            b = -b;
        }
        while (b > 0) {
            //若是奇数，需要额外*x
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
