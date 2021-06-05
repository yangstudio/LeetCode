package yang;

import yang.demo.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.ToIntFunction;

/**
 * @Description: 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * @Author: yangchao
 * @Date: 2021/05/08/14:27
 */
public class LevelOrderII {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(new LinkedList<>(list));
        }
        return res;
    }
}
