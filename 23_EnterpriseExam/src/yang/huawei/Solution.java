package yang.huawei;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/04/22/10:14
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        int len = nums.length;
        boolean[] visited = new boolean[len];
        dfs(nums,res,list,visited,0);
        return res;
    }
    public void dfs(int[] nums,List<List<Integer>> res,List<Integer> list,boolean[] visited, int index) {
        if (index == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                dfs(nums,res,list,visited,index+1);
                visited[i] = false;
                list.remove(index);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4};
        Solution su = new Solution();
        List<List<Integer>> permute = su.permute(nums);
        for (List<Integer> list : permute) {
            System.out.println("=========");
            for (Integer val : list) {
                System.out.print(val+ " ");
            }
        }
    }
}

