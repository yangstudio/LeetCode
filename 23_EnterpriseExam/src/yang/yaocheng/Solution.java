package yang.yaocheng;

import yang.demo.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/05/19/18:51
 */
public class Solution {
        /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param node TreeNode类 二叉树root节点
     * @return int整型一维数组
     */
    public int[] TreeBFS (TreeNode node) {
        // write code here
        if (node == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            list.add(cur.val);
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}






















