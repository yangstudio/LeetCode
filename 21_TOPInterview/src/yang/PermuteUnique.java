package yang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 * @Author: yangchao
 * @Date: 2021/04/01/9:28
 */

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        //怎么处理相等的元素呢？ 排序处理
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(lists,nums,0,used,new LinkedList<>());
        return lists;
    }
    private void backtrack(List<List<Integer>> lists, int[] nums,
                           int index, boolean[] used, List<Integer> list ) {
        if (index == nums.length) {
            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                //剪枝操作：!used[i-1] 是因为nums[i-1]在深度优先遍历的过程中刚刚被撤销选择，
                //对于，used[i-1] = true来说，则不会，例如【2,1,1】由于第二个1为true，所以第三个1可以加入
                if (i >= 1 && nums[i] == nums[i-1] && !used[i-1]) continue;
                list.add(nums[i]);
                used[i] = true;
                backtrack(lists,nums,index+1,used,list);
                used[i] = false;
                list.remove(index);
            }
        }
    }
}
