package yang;

/**
 * @Description: 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @Author: yangchao
 * @Date: 2021/04/27/8:25
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        if (nums.length <= 1) return nums;
        int i = 0, j = nums.length-1;
        while (i < j) {
            while (i < j && nums[i]%2 == 1) {
                i++;
            }
            while (i < j && nums[j]%2 == 0) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    /**
     * @Description:
     * @Author: yangchao
     * @Date: 2021/05/12/14:25
     */
    public static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
