package yang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 * @Author: yangchao
 * @Date: 2021/04/02/14:59
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,0,0,res,new LinkedList<>());
        return res;
    }
    private void dfs(int[] candidates, int target, int sum, int index, List<List<Integer>> res, List<Integer> path) {
        if (sum == target) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            //剪枝操作：1.去重； 2. 排除大于target的和
            if (i >= 1 && candidates[i] == candidates[i-1]) continue;
            if (sum + candidates[i] > target) break;
            sum += candidates[i];
            path.add(candidates[i]);
            dfs(candidates,target,sum,i,res,path);
            sum -= candidates[i];
            path.remove(path.size()-1);
        }
    }
}
