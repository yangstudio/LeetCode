package yang;

import yang.demo.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 993. 二叉树的堂兄弟节点
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 * @Author: yangchao
 * @Date: 2021/04/19/20:18
 */
public class IsCousins {
    //当且仅当一对节点深度相同而父节点不相同时，它们是堂兄弟节点。
    // 一种非常直接的方法就是通过某种方法求出每一个节点的深度与父节点。
    Map<Integer,Integer> depth;
    Map<Integer,TreeNode> parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap<>();
        parent = new HashMap<>();
        dfs(root,null);
        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
    }
    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
            parent.put(node.val,par);
            dfs(node.left,node);
            dfs(node.right,node);
        }
    }
}
