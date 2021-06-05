package yang.demo;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/01/20/15:42
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
