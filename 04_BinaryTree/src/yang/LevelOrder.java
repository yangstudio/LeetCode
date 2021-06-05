package yang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Queue<TreeNode> currQueue = new LinkedList<>();
        currQueue.offer(root);

        while(!currQueue.isEmpty()) {
            //这两个参数本来是放在大循环外面的，后来发现放在外面的话输出一直为空。因为放在外面的话，
            // 我在将elements添加到lists之后和将nextQueue赋值给currQueue之后，为了在下一层循环中还可以使用elements和nextQueue，
            //对他们分别使用了.clear()方法,但是对象是指向内存地址的，尽管在clear之前已经将他们分别赋值给lists[i]和currQueue，
            // 直接clear后仍然会将这两个地方保存的值也清空。
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
            lists.add(elements);
            currQueue = nextQueue;
        }
        return lists;
    }
}
