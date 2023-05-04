package 剑指offer100;

/**
 * @author shizq18
 * @since 2023/4/28
 */
public class 两个链表的第一个公共子节点 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = new ListNode(8);
        headB.next.next.next.next = new ListNode(4);
        headB.next.next.next.next.next = new ListNode(5);
        System.out.println(getIntersectionNode(headA, headB));
    }
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 需要把两个链表合成一个
        ListNode firstNode = headA, secondNode = headB;
        while (firstNode != null || secondNode != null){
            if (firstNode == null){
                firstNode = headB;
            }
            if (secondNode == null){
                secondNode = headA;
            }
            if (firstNode == secondNode){
                return firstNode;
            }
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return null;
    }
}
