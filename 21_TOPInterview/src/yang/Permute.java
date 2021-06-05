package yang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 * @Author: yangchao
 * @Date: 2021/03/12/17:04
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        if (nums == null || nums.length == 0) return lists;
        boolean[] used  = new boolean[nums.length];
        backtrack(nums,0,used,lists,new LinkedList<>());
        return lists;
    }

    private void backtrack(int[] nums, int index, boolean[] used,
                     List<List<Integer>> lists, List<Integer> list) {
        if (index == nums.length) {
            lists.add(new LinkedList<>(list));
            return;
        }
        //在还未选择的数中依次选择一个元素作为下一个位置的元素
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                backtrack(nums,index+1,used,lists,list);
                //下面这两行代码发生了回溯
                list.remove(index);
                used[i] = false;
            }
        }
    }

/*    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        int len = nums.length;
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums,len,0,path,used,res);
        return res;
    }
    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path,boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        //在非叶子结点处，产生不同的分支，这一操作的含义是：在还未选择的数中依次选择一个元素作为下一个位置的元素
        for (int i = 0 ; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums,len,depth+1,path,used,res);
                //注意：下面这两行代码发生了【回溯】，回溯发生在从深层次节点回到浅层次节点的过程中，
                // 代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }*/
}
