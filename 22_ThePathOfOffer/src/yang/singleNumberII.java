package yang;

/**
 * @Description: 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * @Author: yangchao
 * @Date: 2021/05/31/8:33
 */
public class singleNumberII {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            //统计第i位中1的个数
            int oneCount = 0;
            for (int j = 0; j < nums.length; j++) {
                oneCount += (nums[j] >>> i) & 1;
            }
            //如果1的个数不是3的倍数，说明那个只出现一次的数字的二进制位中在这一位是1
            if (oneCount % 3 == 1) {
                res |= 1 << i;
            }
        }
        return res;
    }
}
