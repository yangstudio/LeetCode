package yang;

/**
 * 876. 链表的中间结点
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
