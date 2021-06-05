package yang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 */
public class Subsets {
    int len;
    Deque<Integer> subset;
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) return lists;
        len = nums.length;
        subset = new ArrayDeque<>(len);
        getSubsets(nums,0,lists);
        return lists;
    }
    private void getSubsets(int[] nums, int depth, List<List<Integer>> lists ) {
        if (depth == len) {
            lists.add(new ArrayList<>(subset));
            return;
        }
        subset.addLast(nums[depth]);
        System.out.println("  递归之前 => " + subset);
        getSubsets(nums,depth+1,lists);
        subset.removeLast();
        System.out.println("  递归之后0 => " + subset);
        getSubsets(nums, depth+1, lists);
        System.out.println("  递归之后 => " + subset);
    }
}
