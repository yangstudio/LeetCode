package yang;

import java.util.*;

/**
 * 90. 子集 II
 * https://leetcode-cn.com/problems/subsets-ii/
 */
public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) return lists;
        Arrays.sort(nums);
        getSubsets(nums,0,new ArrayDeque<>(),lists);
        return lists;
    }

    private void getSubsets(int[] nums, int index,ArrayDeque<Integer> subset, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(subset));
        if (index == nums.length) return;
        System.out.println("--------------------------------------------");
        System.out.println("list的元素为:"+lists.get(lists.size()-1));
        System.out.println("--------------------------------------------");
        for (int i = index; i < nums.length; i++) {
            //和上一个数字相同即跳过
            if (i > index && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            System.out.println("  递归之前 subset => " + subset + ";i=> "+i);
            getSubsets(nums,i+1,subset,lists);
            subset.removeLast();
            System.out.println("  递归之后 subset => " + subset + ";i=> "+i);
            System.out.println();
        }
    }
}
