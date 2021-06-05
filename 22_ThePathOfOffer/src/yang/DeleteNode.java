package yang;

import yang.demo.ListNode;

import java.util.List;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/04/25/10:37
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode curr = head;
        while (curr != null) {
            if (curr.next.val == val) break;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}
