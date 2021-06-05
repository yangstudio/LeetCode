package yang;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 剑指 Offer 57 - II. 和为s的连续正数序列
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * @Author: yangchao
 * @Date: 2021/06/01/8:37
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, sum = 3;
        List<int[]> res = new ArrayList<>();
        while (i < j) {
            if(sum == target) {
                int[] ans = new int[j - i + 1];
                for(int k = i; k <= j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            if (sum >= target) {
                sum -= i;
                i++;
            } else {  //顺序不能颠倒！！！
                j++;
                sum += j;
            }
        }
        return res.toArray(new int[0][]);
    }
}
