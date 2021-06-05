package yang;

/**
 * 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode newList = null, temp = null;

        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (newList == null) {
                    newList = l1;
                    temp = newList;
                } else {
                    temp.next = l1;
                    temp = temp.next;
                }
                l1 = l1.next;

            } else {
                if (newList == null) {
                    newList = l2;
                    temp = newList;
                } else {
                    temp.next = l2;
                    temp = temp.next;
                }
                l2 = l2.next;
            }
        }

        temp.next = l1 == null? l2 : l1;
        return newList;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }



}
