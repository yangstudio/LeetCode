package yang;

import yang.demo.ListNode;

/**
 * @Description: 剑指 Offer 24. 反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * @Author: yangchao
 * @Date: 2021/04/27/8:45
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head.next == null) return head;
        ListNode pre = new ListNode(head.val);
        ListNode cur = head.next;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
