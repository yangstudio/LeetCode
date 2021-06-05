package yang;

import yang.demo.ListNode;

/**
 * @Description: 剑指 Offer 22. 链表中倒数第k个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @Author: yangchao
 * @Date: 2021/04/27/8:36
 */
public class getKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
       ListNode node = head;
       int len = 0;
       while (node != null) {
           len++;
           node = node.next;
       }
       if (len < k) return null;
       int index = len-k;
       while (index > 0) {
           head = head.next;
           index--;
       }
       return head;
    }
}
