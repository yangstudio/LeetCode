package yang;

import yang.demo.ListNode;

import java.util.*;

/**
 * @Description: 23. 合并K个升序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @Author: yangchao
 * @Date: 2021/03/09/8:32
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        //构建小顶堆
        Queue<ListNode> pq = new PriorityQueue<>((n1,n2)->n1.val - n2.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        return dummy.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        List arr = new LinkedList();
        for (ListNode head: lists) {
            while (head != null){
                arr.add(head.val);
                head = head.next;
            }
        }
        Collections.sort(arr);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!arr.isEmpty()) {
            curr.next = new ListNode((Integer) arr.remove(0));
            curr = curr.next;
        }
        return dummy.next;
    }
}
