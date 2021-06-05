package yang;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 662. 二叉树最大宽度:每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 */
public class WidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        int width = 1;
        list.add(1);
        queue.offer(root);
        while(!queue.isEmpty()) {
            //每一层的节点个数；这跟我之前的做法不一样，
            // 前面的层序遍历是单独用一个队列来存储下一层的节点
            int currSize = queue.size();
            while(currSize-- > 0 ) {
                TreeNode node = queue.poll();
                int currIndex = list.removeFirst();
                if (node.left != null) {
                    queue.offer(node.left);
                    list.add(currIndex * 2);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    list.add(currIndex * 2+1);
                }
            }
            //遍历最后一层时，到此处list是空的，所以需要判断一下
            if (list.size() >= 2) {
                width = Math.max(width, list.getLast() - list.getFirst() + 1);
            }
        }
        return width;
    }
}
