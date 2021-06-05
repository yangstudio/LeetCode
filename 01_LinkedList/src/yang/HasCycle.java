package yang;

/**
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        while(head != null) {
            if (fast == null || fast.next == null) return false;

            fast = fast.next.next;
            head = head.next;

            if (fast == head) return true;
        }
        return false;
    }
}
