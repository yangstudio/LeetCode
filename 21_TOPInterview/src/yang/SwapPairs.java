package yang;

import yang.demo.ListNode;

/**
 * @Description: 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @Author: yangchao
 * @Date: 2021/03/08/10:54
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;

        while(curr != null && curr.next != null && curr.next.next != null) {
            ListNode start = curr.next;
            ListNode end = curr.next.next;
            curr.next = end;
            start.next = end.next;
            end.next = start;
            curr = start;
        }
        return dummy.next;
    }
}
