package yang;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 剑指 Offer 35. 复杂链表的复制
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * @Author: yangchao
 * @Date: 2021/05/12/14:23
 */
public class CopyRandomList {
    public Exchange.Node copyRandomList(Exchange.Node head) {
        if (head  == null) return null;
        Exchange.Node cur = head;
        Map<Exchange.Node, Exchange.Node> map = new HashMap<>();
        //复制各节点，并建立“原节点 -> 新节点” 的Map映射
        while (cur != null) {
            map.put(cur,new Exchange.Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 构建新链表的nexe和random指向
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 返回新链表的头结点
        return map.get(head);
    }
}


