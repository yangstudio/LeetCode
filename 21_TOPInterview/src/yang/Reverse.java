package yang;

/**
 * @Description: 7. 整数反转
 * https://leetcode-cn.com/problems/reverse-integer/
 * @Author: yangchao
 * @Date: 2021/03/01/8:27
 */

public class Reverse {
    public int reverse(int x) {
        long res = 0;
        while(x != 0) {
            int tmp = x % 10;
            res = res*10 + tmp;
            x /= 10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        return (int) res;
    }
}
