package yang;

import yang.demo.ListNode;

/**
 * @Description: 147. 对链表进行插入排序
 * https://leetcode-cn.com/problems/insertion-sort-list/
 * @Author: yangchao
 * @Date: 2021/04/05/10:17
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode lastSorted = head;
        //curr为待插入元素
        ListNode curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next; //lastSorted 为链表的已排序部分的最后一个节点
            } else {
                //prev是插入节点curr位置的前一个节点
                ListNode prev = dummy;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                //对curr进行插入操作
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummy.next;
    }
}
