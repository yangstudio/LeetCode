package yang;

import javax.swing.*;

/**
 * 148. 排序链表: 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * https://leetcode-cn.com/problems/sort-list/
 */

public class SortList {

/*    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode p = head;
        p.next = new ListNode(4);
        p.next.next = new ListNode(2);
        p.next.next.next = new ListNode(6);
        p.next.next.next.next = new ListNode(5);
        p.next.next.next.next.next = new ListNode(7);
        p.next.next.next.next.next.next = new ListNode(1);

        ListNode left = head;
        ListNode right = split(left,2);

        while(left != null) {
            System.out.println(left.val);
            left = left.next;
        }


    }*/

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        //获取链表长度
        int len = listNodeLength(head);

        //哨兵节点
        ListNode sentry = new ListNode(-1);
        sentry.next = head;

        //循环log n 次
        for (int i = 1; i < len ; i <<= 1) {
            ListNode prev = sentry;
            ListNode curr = sentry.next;

            //循环 n 次
            while(curr != null) {
                ListNode left = curr;
                ListNode right = split(left,i);
                curr = split(right,i);
                prev.next = mergeTwoLists(left,right);

                while(prev.next != null) {
                    prev = prev.next;
                }
            }
        }
        return sentry.next;
    }

    //获取链表的长度
    private int listNodeLength(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while(curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }

    //根据步长分隔链表
    private ListNode split(ListNode head, int step) {
        if (head == null) return null;

        for (int i = 1; head.next != null && i < step; i++) {
            head = head.next;
        }

        ListNode right = head.next;
        head.next = null;
        return right;
    }


    //合并两个有序链表
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(-1);
        ListNode curr = sentry;

        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;
        return sentry.next;
    }
}
