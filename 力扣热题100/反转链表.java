package 力扣热题100;

import 单链表问题.ListNode;

/**
 * @Author shizq18
 * @Date 2023/8/18
 * @Description
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}