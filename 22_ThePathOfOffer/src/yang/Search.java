package yang;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description: 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * @Author: yangchao
 * @Date: 2021/05/24/14:19
 */
public class Search {
    public int search(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer val : nums) {
            if (!map.containsKey(val)) {
                map.put(val,1);
            } else {
                map.put(val,map.get(val)+1);
            }
        }
        return map.containsKey(target)? map.get(target) : 0;
    }
}
