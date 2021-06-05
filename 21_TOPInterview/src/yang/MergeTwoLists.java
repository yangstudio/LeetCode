package yang;

import yang.demo.ListNode;

/**
 * @Description: 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @Author: yangchao
 * @Date: 2021/03/04/8:51
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        //合并之后最多只有一个还没有被合并，我们直接将剩下还未合并完的链表末尾指向已经合并完的链表即可
        prev.next = l1 == null? l2 : l1;
        return prehead.next;
    }
}
