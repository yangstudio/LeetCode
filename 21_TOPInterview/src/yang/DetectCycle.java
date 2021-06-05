package yang;

import yang.demo.ListNode;

/**
 * @Description: 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @Author: yangchao
 * @Date: 2021/03/03/14:40
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
