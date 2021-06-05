package yang;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 40. 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * @Author: yangchao
 * @Date: 2021/04/02/15:22
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        dfs(candidates,target,0,0,used,res,new LinkedList<>());
        return res;
    }
    private void dfs(int[] candidates, int target, int sum, int index,
                     boolean[] used, List<List<Integer>> res, List<Integer> path) {
        if (sum == target) {
            res.add(new LinkedList<>(path));
            return;
        }
        if (index >= candidates.length) return;

        for (int i = index; i < candidates.length; i++) {
            if (i >= 1 && candidates[i] == candidates[i-1] && !used[i-1]) continue;
            if (sum+candidates[i] > target) return;
            sum += candidates[i];
            path.add(candidates[i]);
            used[i] = true;
            dfs(candidates,target,sum,i+1,used,res,path);
            sum -= candidates[i];
            path.remove(path.size()-1);
            used[i] = false;
        }
    }

    @Test
    public void combinationSumTest(){
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        CombinationSum2 cbts = new CombinationSum2();
        List<List<Integer>> lists = cbts.combinationSum2(candidates, 8);
        for (List<Integer> list : lists) {
            System.out.println("========================");
            for (Integer val : list) {
                System.out.println(val);
            }
        }
    }
}
