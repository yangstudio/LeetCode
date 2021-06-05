package yang;

/**
 * @Description: 剑指 Offer 16. 数值的整数次方
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * @Author: yangchao
 * @Date: 2021/04/26/9:43
 */
public class MyPow {
    public double myPow(double x, int n) {
        double res = 1;
        boolean flag = false;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                if (x == -1) return 1;
                n = Integer.MAX_VALUE;
            } else {
                n = -n;
            }
            flag = true;
        }
        while (n > 0) {
            if (n%2 == 1) {
                res = res*x;
            }
            x = x*x;
            n = n/2;
        }
        return flag == false ? res : 1/res;
    }
}
