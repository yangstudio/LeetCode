package yang;

/**
 * @Description: 69. x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 * @Author: yangchao
 * @Date: 2020/12/14/8:35
 */
public class MySqrt {
    public int mySqrt(int x) {
        int left = 0, right = x;
        int res = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if ((long)mid * mid <= x) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
