package yang;

import yang.demo.ListNode;

/**
 * @Description: 143. 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 * @Author: yangchao
 * @Date: 2021/03/08/10:27
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;

        //1.将链表分割成两部分
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        //2. 翻转第二个链表
        head2 = reverseList(head2);

        //3. 依次连接两个链表中的节点
        while(head2 != null) {
            ListNode temp = head2.next;
            head2.next = head.next;
            head.next = head2;
            head = head2.next;
            head2 = temp;
        }
    }
    /*翻转链表*/
    private ListNode reverseList(ListNode head) {
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
}
