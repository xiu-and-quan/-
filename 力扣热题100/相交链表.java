package 力扣热题100;

import 单链表问题.ListNode;

/**
 * @Author shizq18
 * @Date 2023/8/18
 * @Description
 */
public class 相交链表 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(8);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode listNode1 = new ListNode(5);
        listNode1.next = new ListNode(6);
        listNode1.next.next = new ListNode(1);
        listNode1.next.next.next = new ListNode(8);
        listNode1.next.next.next.next = new ListNode(4);
        listNode1.next.next.next.next.next = new ListNode(5);
        getIntersectionNode(listNode, listNode1);
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //把两个链表合成一个
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null || tempB != null) {
            if (tempA == null) {
                tempA = headB;
            }
            if (tempB == null) {
                tempB = headA;
            }
            if (tempA == tempB) {
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
}
