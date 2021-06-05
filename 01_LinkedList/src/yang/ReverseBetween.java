package yang;

import java.util.Stack;

/**
 * 92. 反转链表 II:反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;

        for (int i = 2; i <= 5; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }

        ListNode newHead = reverseBetween1(head,1,4);
        while(newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;
        int step = 1;
        //将g移动到第一个要反转的节点的前面，将p移动到第一个要反转的节点的位置上
        while (step < m ) {
            g = g.next;
            p = p.next;
            step++;
        }
        //g固定不动，只移动p，将p后面的元素删除，然后添加到g后面，也即头插法
        for (int i = 0; i < n - m; i++) {
            ListNode temp = p.next;
            p.next = p.next.next;

            temp.next = g.next;
            g.next = temp;
        }
        return dummyHead.next;
    }

    public static ListNode reverseBetween1(ListNode head, int m, int n) {
        if (m == n) return head;
        boolean isEntry = false;   //m为1时没有prev，需要另外处理
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head, prev = head,next = null;

        for (int i = 1; i < m; i++) {
            if (current == null) return null;
            if (i == m-1) {
                prev = current;
            }
            current = current.next;
        }
        for (int i = 0; i <= n-m ; i++) {
            stack.push(current);
            if (current == null) break;
            current = current.next;
        }
        next = current;
        while(!stack.isEmpty()) {
            if (m == 1 && !isEntry) {
                head  = stack.pop();
                prev = head;
                isEntry = true;
            } else {
                prev.next = stack.pop();
                prev = prev.next;
            }
        }
        if (prev != null) {
            prev.next = next;
        }
        return head;
    }

}
