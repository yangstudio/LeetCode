package yang;

/**
 * @Description: 50. Pow(x, n)
 *https://leetcode-cn.com/problems/powx-n/
 * @Author: yangchao
 * @Date: 2021/03/29/19:23
 */
public class MyPow {
    public double myPow(double x, int n) {
        if (x == 0.0f) return 0.0d;
        long b = n;
        double res = 1;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
            System.out.println(b);
        }
        return res;
    }
}
