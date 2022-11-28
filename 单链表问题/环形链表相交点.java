package 单链表问题;

public class 环形链表相交点 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null){
            return null;
        }
        while( fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                break;
            }
        }
        if( fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while(slow != fast){
            fast =fast.next;
            slow = slow.next;

        }
        return slow;
    }
}
