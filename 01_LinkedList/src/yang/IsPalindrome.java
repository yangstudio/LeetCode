package yang;

/**
 * 234. 回文链表
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        /*ListNode p = head;
        p.next = new ListNode(2);
        p.next.next = new ListNode(3);
        p.next.next.next = new ListNode(2);
        p.next.next.next.next = new ListNode(1);*/

        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode fast = head, slow = head;

        //找到中间节点，取后半部分链表，并将其翻转
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        newHead = reverseList(newHead);

        //将翻转后的链表与原始链表的前半部分比较，如果每个节点的值都相等，则是回文联表
        while(newHead != null) {
            if (newHead.val != head.val) return false;
            newHead = newHead.next;
            head = head.next;
        }

        return true;
    }

    //翻转链表
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
