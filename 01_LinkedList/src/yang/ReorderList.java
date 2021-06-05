package yang;

/**
 * 143. 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(2);
        p.next.next = new ListNode(3);
        p.next.next.next = new ListNode(4);
        p.next.next.next.next = new ListNode(5);
        p.next.next.next.next.next = new ListNode(6);
        reorderList(head);
    }
    public static void  reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        //找到中间节点，将链表分成两个
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        //第二个链表倒置
        newHead = reverseList(newHead);

        //链表节点依次连接
        while(newHead != null) {
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }
    }

    //链表倒置
    private static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while( head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }
}
