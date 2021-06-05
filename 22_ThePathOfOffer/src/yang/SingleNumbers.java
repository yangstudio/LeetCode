package yang;

import org.junit.Test;

/**
 * @Description: 剑指 Offer 56 - I. 数组中数字出现的次数
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * @Author: yangchao
 * @Date: 2021/05/28/14:31
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int k = 0;
        //计算异或和
        for(int num : nums) {
            k ^= num;
        }
        int mask = 1;
        while ((k & mask) == 0) {
            mask <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }
    @Test
    public void test(){
        SingleNumbers sn = new SingleNumbers();
        int[] nums = new int[]{4,1,4,6};
        int[] res = sn.singleNumbers(nums);
        System.out.println(res[0] + " " + res[1]);
    }
}
