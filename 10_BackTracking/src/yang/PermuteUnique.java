package yang;

import java.util.*;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) return lists;
        int len = nums.length;
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);
        Arrays.sort(nums);
        dfs(nums, len, 0, path, used, lists);
        return lists;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> lists) {
        if (depth == len) {
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) continue;
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
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
