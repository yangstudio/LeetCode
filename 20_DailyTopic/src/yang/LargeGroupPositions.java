package yang;

import java.util.*;

/**
 * @Description: 每日一题： 830. 较大分组的位置
 * https://leetcode-cn.com/problems/positions-of-large-groups/
 * @Author: yangchao
 * @Date: 2021/01/05/8:26
 */
public class LargeGroupPositions {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int len = s.length();
        int num = 1;
        for (int i = 0; i < len; i++) {
            if (i == len - 1 || s.charAt(i) != s.charAt(i+1)) {
                if (num >= 3) {
                    res.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return res;
    }
}
