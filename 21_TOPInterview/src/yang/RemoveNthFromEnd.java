package yang;

import yang.demo.ListNode;

/**
 * @Description: 19. 删除链表的倒数第 N 个结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @Author: yangchao
 * @Date: 2021/03/05/8:58
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        //让fast与slow之间相差n个节点距离，那么当fast指向链表最后一个节点时，
        // slow指向的下一个节点既是题目所要求的要删除的节点
        for (int i = 1; i < n && fast != null; i++) {
            fast = fast.next;
        }
        if (fast == null) return null;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
