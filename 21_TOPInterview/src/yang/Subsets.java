package yang;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 * @Author: yangchao
 * @Date: 2021/04/02/15:55
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(nums,0,res,new LinkedList<>());
        return res;
    }
    private void dfs(int[] nums, int index, List<List<Integer>> res,List<Integer> path) {
        if (index >= nums.length) return;
        res.add(new LinkedList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums,index+1,res,path);
            path.remove(path.size()-1);
        }
    }
}
