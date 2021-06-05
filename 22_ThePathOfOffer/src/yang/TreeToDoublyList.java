package yang;

import yang.demo.Node;

/**
 * @Description: 剑指 Offer 36. 二叉搜索树与双向链表
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * @Author: yangchao
 * @Date: 2021/05/13/9:03
 */
public class TreeToDoublyList {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        // 进行头节点和尾节点的相互指向，这两句的顺序也是可以颠倒的
        head.left = pre;
        pre.right = head;
        return head;
    }
    private void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        if (pre != null) {
            // 当 pre 不为空时： 修改双向节点引用，即 pre.right = cur
            pre.right = cur;
        } else {
            // 当 pre 为空时： 代表正在访问链表头节点，记为 head ；
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
