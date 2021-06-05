package yang;

/**
 * @Description: 69. x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 * @Author: yangchao
 * @Date: 2021/03/29/20:40
 */
public class MySqrt {
    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if ((long)mid*mid == x) {
                return mid;
            } else if ((long)mid*mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left-1;
    }
}
