package yang;

import java.util.*;

/**
 * 107. 二叉树的层次遍历 II
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Stack<List<Integer>> stacks = new Stack<>();
        if (root == null) return lists;
        Queue<TreeNode> currQueue = new LinkedList<>();
        currQueue.offer(root);

        while(!currQueue.isEmpty()) {
            List<Integer> elements = new ArrayList<>();
            Queue<TreeNode> nextQueue = new LinkedList<>();
            while (!currQueue.isEmpty()) {
                TreeNode node = currQueue.poll();
                elements.add(node.val);
                if (node.left != null) {
                    nextQueue.offer(node.left);
                }
                if (node.right != null) {
                    nextQueue.offer(node.right);
                }
            }
            stacks.push(elements);
            currQueue = nextQueue;
        }
        while(!stacks.isEmpty()) {
            lists.add(stacks.pop());
        }
        return lists;
    }
}
