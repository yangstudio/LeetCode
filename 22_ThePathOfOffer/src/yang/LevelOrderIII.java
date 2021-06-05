package yang;

import yang.demo.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * @Author: yangchao
 * @Date: 2021/05/08/14:38
 */
public class LevelOrderIII {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new LinkedList<>();
            while (len > 0) {
                len--;
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (res.size()%2 == 1) {
                Collections.reverse(list);
            }
            res.add(new LinkedList<>(list));
        }
        return res;
    }
}
