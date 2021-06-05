package yang;

import java.util.*;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) return lists;
        int len = nums.length;
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, lists);
        return lists;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> lists) {
        if (depth == len) {
            lists.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                System.out.println("  递归之前 => " + path);
                dfs(nums, len, depth + 1, path, used, lists);

                used[i] = false;
                path.removeLast();
                System.out.println("递归之后 => " + path);
            }
        }
    }
}
