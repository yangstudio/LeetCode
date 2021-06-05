package yang;

import org.junit.Test;
import yang.demo.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description: 剑指 Offer 07. 重建二叉树 : 前序遍历 + 中序遍历
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * @Author: yangchao
 * @Date: 2021/04/16/8:39
 */
public class BuildTree {
    /*
    递归 : https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-di-gui-fa-qin/
    * */
    Map<Integer,Integer> map; // 标记中序遍历
    int[] preorder;  //保留的前序遍历，方便递归时依据索引查看前序遍历的值
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return recur(0,0,inorder.length-1);
    }
        //三个索引分别为
        //当前根节点在前序遍历中的索引【前序遍历中的位置】
        //递归树的左边界，即数组左边界【中序遍历中的位置】
        //递归树的右边界，即数组右边界【中序遍历中的位置】
    TreeNode recur(int preRootIdx, int inLeft, int inRight) {
        if (inLeft > inRight) return null;
        TreeNode root = new TreeNode(preorder[preRootIdx]);
        int inRootIdx = map.get(preorder[preRootIdx]);
        root.left = recur(preRootIdx+1,inLeft,inRootIdx-1);
        root.right = recur(preRootIdx+inRootIdx-inLeft+1,inRootIdx+1,inRight);
        return root;
    }

    //2. 迭代 ：看的是官方代码
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        // stack 来维护【当前节点的所有还没有考虑过右儿子的祖先节点】
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //inprderIndex 对应的节点是「当前节点不断往左走达到的最终节点」
        int inprderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inprderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inprderIndex]) {
                    node = stack.pop();
                    inprderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }




    @Test
    public void buildTreeTest(){
        int[] preorder = new int[]{3,9,8,5,4,10,20,15,7};
        int[] inorder = new int[] {4,5,8,10,9,3,15,20,7};
        BuildTree bd = new BuildTree();
        TreeNode node = bd.buildTree(preorder, inorder);

    }
}
