package yang;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * @Author: yangchao
 * @Date: 2021/01/20/15:02
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 方法2：哈希表
     */
    public int[] twoSumII(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[1];
    }
}
