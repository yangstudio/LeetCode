package yang;

/**
 * 82. 删除排序链表中的重复元素 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class DeleteDuplicates_2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(2);
        p.next.next = new ListNode(3);
        p.next.next.next = new ListNode(3);
        p.next.next.next.next = new ListNode(4);
        p.next.next.next.next.next = new ListNode(4);
        p.next.next.next.next.next.next = new ListNode(5);
        /*p.next.next.next.next.next.next.next = new ListNode(5);*/

        ListNode newHead = deleteDuplicates2(head);
        while(newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }
    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        boolean isValid = true;  //判断当前节点是否有效，如果cur 与 cur.
        ListNode newHead = null, temp = null;

        while( cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
                if (cur.next == null) {
                    if (newHead == null) return null;
                    temp.next = null;
                }
                isValid = false;
            } else {
                if (isValid) {
                    if (newHead != null) {
                        temp.next = cur;
                        temp = temp.next;
                    } else {
                        newHead = cur;
                        temp = newHead;
                    }
                }
                cur = cur.next;
                isValid = true;
                if (cur.next == null) {
                    if (newHead == null) {
                        newHead = cur;
                    } else {
                        temp.next = cur;
                    }
                }
            }
        }
        return newHead;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = dummy;
        ListNode b = head;
        while(b!=null && b.next!=null) {
            //初始化的时a指向的是哑结点，所以比较逻辑应该是a的下一个节点和b的下一个节点
            if (a.next.val!=b.next.val) {
                a = a.next;
                b = b.next;
            }
            else {
                //如果a、b指向的节点值相等，就不断移动b，直到a、b指向的值不相等
                while(b!=null && b.next!=null && a.next.val==b.next.val) {
                    b = b.next;
                }
                a.next = b.next;
                b = b.next;
            }
        }
        return dummy.next;
    }
}
