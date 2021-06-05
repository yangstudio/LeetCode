package yang;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        //申请节点，pre和 cur，pre指向nul
        ListNode prev = null;
        ListNode curr = head;
        while( curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public ListNode reverseLis2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseLis2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
