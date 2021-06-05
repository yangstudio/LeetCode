package yang;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */

public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while(fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while(head != null) {
            if (nodeSet.contains(head)) return head;
            nodeSet.add(head);
            head = head.next;
        }
        return null;
    }
}
