package yang;

import yang.demo.ListNode;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description: 82. 删除排序链表中的重复元素 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * @Author: yangchao
 * @Date: 2021/03/03/15:38
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            //初始化时prev指向的是哑结点，所以比较的应该是prev的下一个节点和curr的下一个节点
            if (prev.next.val != curr.next.val) {
                prev = prev.next;
                curr = curr.next;
            } else {
                //如果prev和curr指向的节点值相等，就不断移动curr
                while (curr != null && curr.next != null && prev.next.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next = curr.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
