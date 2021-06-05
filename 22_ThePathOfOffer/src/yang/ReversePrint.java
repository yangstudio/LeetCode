package yang;

import yang.demo.ListNode;

import java.util.Stack;

/**
 * @Description: 剑指 Offer 06. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @Author: yangchao
 * @Date: 2021/04/15/15:16
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int len = stack.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}
