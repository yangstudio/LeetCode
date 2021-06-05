package yang;

import yang.demo.ListNode;

import java.util.List;

/**
 * @Description: 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @Author: yangchao
 * @Date: 2021/01/21/8:41
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        int sign = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int val = v1 + v2 + sign;

            sign = val > 9 ? 1 : 0;
            val = val % 10;
            node.next = new ListNode(val);
            node = node.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (sign == 1) node.next = new ListNode(1);
        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        int sign = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val;
            val += sign;
            sign = 0;
            if (val >= 10) {
                val = val - 10;
                sign = 1;
            }
            node.next = new ListNode(val);
            node = node.next;
            if (l1.next == null || l2.next == null) break;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1.next == null && l2.next == null) {
            if (sign != 0) {
                node.next = new ListNode(sign);
            }
            return dummy.next;

        } else if (l2.next != null) {
            if (sign != 0) {
                while (l2.next != null) {
                    int val = sign + l2.next.val;
                    sign = 0;
                    if (val >= 10) {
                        val = val - 10;
                        sign = 1;
                    }
                    node.next = new ListNode(val);
                    node = node.next;
                    l2 = l2.next;
                }
                if (sign != 0) node.next = new ListNode(sign);
            } else {
                node.next = l2.next;
            }
        } else {
            if (sign != 0) {
                while (l1.next != null) {
                    int val = sign + l1.next.val;
                    sign = 0;
                    if (val >= 10) {
                        val = val - 10;
                        sign = 1;
                    }
                    node.next = new ListNode(val);
                    node = node.next;
                    l1 = l1.next;
                }
                if (sign != 0) node.next = new ListNode(sign);
            } else {
                node.next = l1.next;
            }
        }
        return dummy.next;
    }
}
