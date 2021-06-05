package yang;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 剑指 Offer 61. 扑克牌中的顺子
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * @Author: yangchao
 * @Date: 2021/06/04/8:13
 */
public class IsStraight {
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) continue;
            max = Math.max(max,num);
            min = Math.min(min,num);
            if (repeat.contains(num))return false;
            repeat.add(num);
        }
        return max-min < 5;
    }
}
