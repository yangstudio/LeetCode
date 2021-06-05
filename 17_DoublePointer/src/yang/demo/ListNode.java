package yang.demo;

/**
 * @Description: Definition for singly-linked list.
 * @Author: yangchao
 * @Date: 2021/01/18/14:18
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
