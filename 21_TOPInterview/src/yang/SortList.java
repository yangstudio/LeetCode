package yang;

import yang.demo.ListNode;

/**
 * @Description: 148. 排序链表 【使用归并排序】
 * https://leetcode-cn.com/problems/sort-list/
 * @Author: yangchao
 * @Date: 2021/03/04/15:35
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        //找到链表的中间节点，并将链表分割断开
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode midNode = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(midNode);
        return mergeTwoLists(left,right);

    }

    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        //合并之后最多只有一个链表没有被合并，我们直接将剩下的链表连接到新链表末端即可
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}
