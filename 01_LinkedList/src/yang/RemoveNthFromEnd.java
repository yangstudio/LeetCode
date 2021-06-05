package yang;

/**
 * 19. 删除链表的倒数第N个节点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head;
        ListNode prev = dummy;
        for (int i = 1; i < n && fast != null; i++) {
            fast = fast.next;
        }
        if (fast == null) return null;

        while (fast.next != null) {
            prev = prev.next;
            fast = fast.next;
        }
        prev.next = prev.next.next;

        return dummy.next;
    }
}
