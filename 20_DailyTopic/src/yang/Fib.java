package yang;

/**
 * @Description: 每日一题：509. 斐波那契数
 * https://leetcode-cn.com/problems/fibonacci-number/
 * @Author: yangchao
 * @Date: 2021/01/04/10:19
 */
public class Fib {
    public int fib(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
