package yang;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 228. 汇总区间
 * https://leetcode-cn.com/problems/summary-ranges/
 * @Author: yangchao
 * @Date: 2021/01/11/8:29
 */

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        StringBuilder sb = new StringBuilder();
        //s指向第一个区间的起始位置
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            //i向后遍历，直到不满足连续递增【nums[i+1] != nums[i]+1)】或者数组已完成遍历
            if (i+1 == nums.length || nums[i+1] != nums[i]+1) {
                //将当前区间[s,i]写入结果列表
                if (s != i) {
                    sb.append(nums[s]+"->"+nums[i]);
                } else {
                    sb.append(nums[s]+"");
                }
                res.add(sb.toString());
                //清空StringBuilder缓存
                sb.delete(0,sb.length());
                //将s更新为i+1，作为下一个区间的起始位置
                s = i+1;
            }
        }
        return res;
    }
}
