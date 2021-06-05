package yang;

import org.junit.Test;
import yang.demo.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 剑指 Offer 34. 二叉树中和为某一值的路径
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * @Author: yangchao
 * @Date: 2021/05/12/8:21
 */
public class PathSum {
    List<List<Integer>> res;
    List<Integer> list;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new LinkedList<>();
        list = new LinkedList<>();
        if (root == null) return res;
        dfs(root,target,0);
        return res;
    }
    private void dfs(TreeNode node, int target,int sum) {
        if (node.left == null && node.right == null) {
            sum += node.val;
            if (sum != target) return;
            list.add(node.val);
            res.add(new LinkedList<>(list));
            //回溯去掉刚添加的值，debug第一个测试用例就知道了
            list.remove(list.size()-1);
            return;
        }
        sum += node.val;
        //如果node.val是负值的话就不满足，会出错
        //if (sum > target) return;
        list.add(node.val);
        if (node.left != null) dfs(node.left,target,sum);
        if(node.right != null) dfs(node.right,target,sum);
        //sum -= node.val;  int类型是值传递，不需要再这里处理，回溯后sum的值就是之前执行dfs时的num值
        list.remove(list.size()-1);
    }

    @Test
    public void test() {
        PathSum ps = new PathSum();
        TreeNode root = ps.buildTree();
        List<List<Integer>> res = ps.pathSum(root, 22);
        for (List<Integer> list : res) {
            for (Integer val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private TreeNode buildTree() {
/*        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);*/

        TreeNode root = new TreeNode(-2,null,new TreeNode(-3));

        return root;
    }
}
