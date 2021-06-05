package yang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 147. 对链表进行插入排序
 * https://leetcode-cn.com/problems/insertion-sort-list/
 * @Author: yangchao
 * @Date: 2020/12/03/8:37
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummyHead = new ListNode(0);       //引入哑节点
        dummyHead.next = head;                         //目的是在head之前插入节点
        ListNode lastSorted = head;                    //lastSorted为链表已经排好序的最后一个节点并初始化
        ListNode curr = head.next;                     //curr为待插入元素

        while(curr != null) {
            if (lastSorted.val <= curr.val) {          //说明curr应该位于lastSorted之后
                lastSorted = lastSorted.next;          //将lastSorted后移一位,curr变成新的lastSorted
            } else {
                ListNode prev = dummyHead;             //prev是插入节点curr位置的前一个节点
                while (prev.next.val <= curr.val) {    // 循环退出的条件是找到curr应该插入的位置
                    prev = prev.next;
                }
                //对curr进行插入操作
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;                    //此时curr为下一个待插入的元素
        }
        return dummyHead.next;
    }
}
