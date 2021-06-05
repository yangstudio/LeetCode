package yang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class CombinationSum {
    List<List<Integer>> lists;
    ArrayDeque<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        lists = new ArrayList<>();
        path = new ArrayDeque<>();
        if (candidates.length == 0) return lists;
        //排序，方便后面的剪枝操作
        Arrays.sort(candidates);
        int sums = 0;
        getSumsList(candidates,sums,target,0);
        return lists;
    }
    private void getSumsList(int[] candidates, int sums, int target, int depth) {
        if (sums == target) {
            lists.add(new ArrayList<>(path));
            System.out.println("list的元素为:"+lists.get(lists.size()-1));
            return;
        }
        for (int i = depth; i < candidates.length; i++) {
            sums += candidates[i];
            //剪枝操作，已经大于target了，由于事先对candidates排序了，
            // 后面的肯定也大于target，直接退出循环即可
            if (sums > target) break;
            path.addLast(candidates[i]);
            System.out.println("  递归之前 => " + path);
            getSumsList(candidates,sums,target,i);
            sums -= candidates[i];
            path.removeLast();
            System.out.println("  递归之后 => " + path);
        }
    }
}
