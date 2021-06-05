package yang;

import java.util.Arrays;

/**
 * @Description: 剑指 Offer 45. 把数组排成最小的数
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 * @Author: yangchao
 * @Date: 2021/05/17/8:51
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs,(s1,s2) -> (s1+s2).compareTo(s2+s1));
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }
}
