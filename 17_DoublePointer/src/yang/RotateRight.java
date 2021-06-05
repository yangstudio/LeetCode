package yang;

import yang.demo.ListNode;

/**
 * @Description: 61. 旋转链表
 * https://leetcode-cn.com/problems/rotate-list/
 * @Author: yangchao
 * @Date: 2021/01/18/14:16
 */

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head;
        int size = 1;
        while (p1.next != null) {
            p1 = p1.next;
            size++;
        }
        //让链表成环
        p1.next = head;
        ListNode newTail = head;
        //表示尾部是在第几个节点上
        k = size - (k % size) - 1;
        while (k > 0) {
            newTail = newTail.next;
            k--;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}



