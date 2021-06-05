package yang;

/**
 * @Description: 剑指 Offer 44. 数字序列中某一位的数字
 * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 * @Author: yangchao
 * @Date: 2021/05/16/8:18
 */
public class FindNthDigit {
    public int findNthDigit(int n) {
        if (n < 10 ) return n;
        int digit = 1;
        long start = 1;
        long count = 9;
        while(n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit*start*9;
        }
        // 这里取n-1的原因是:当n对应num中的最后一位时，不会由于进位，错误的寻找到下一个数字。
        long num = start + (n - 1) / digit;
        // (n-1)&digit == (n-1) % digit;
        // 这里用(n-1)的目的是String.charAt(i)的i是从索引0开始的
        return Long.toString(num).charAt((n-1)%digit) - '0';
    }
}
