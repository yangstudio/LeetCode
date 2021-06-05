package yang;

/**
 * 108. 将有序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        TreeNode root = new TreeNode(nums[nums.length >> 1]);
        int[] leftNums = new int[nums.length >> 1];
        int[] rightNums = new int[(nums.length-1) >> 1];
        System.arraycopy(nums,0,leftNums,0,leftNums.length);
        System.arraycopy(nums,leftNums.length+1,rightNums,0,rightNums.length);
        root.left = sortedArrayToBST(leftNums);
        root.right = sortedArrayToBST(rightNums);
        return root;
    }
}
