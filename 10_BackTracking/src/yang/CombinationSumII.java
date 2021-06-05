package yang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/11/19/14:15
 */
public class CombinationSumII {
    List<List<Integer>> lists;
    ArrayDeque<Integer> path;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        lists = new ArrayList<>();
        path = new ArrayDeque<>();
        int sums = 0;
        //在candidates中有重复元素时，排序后值相等的挨在一起了，通过设置used数组方便剪枝
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];

        getSumsList(candidates,target,sums,0,used);
        return lists;
    }
    private void getSumsList(int[] candidates, int target,int sums, int index,boolean[] used) {
        if (sums == target) {
            lists.add(new ArrayList<>(path));
            System.out.println("list的元素为:"+lists.get(lists.size()-1));
            System.out.println("-----------------------------");
            return;
        }
        if (index == candidates.length) return;
        for (int i = index; i < candidates.length;i++) {
            if (i > 0 && candidates[i] == candidates[i-1] && !used[i-1]) continue;
            sums += candidates[i];
            if (sums > target) break;
            path.addLast(candidates[i]);
            used[i] = true;
            System.out.println("  递归之前 => " + path);
            getSumsList(candidates,target,sums,i+1,used);
            sums -= candidates[i];
            path.removeLast();
            used[i] = false;
            System.out.println("  递归之后 => " + path);
        }
    }
}
