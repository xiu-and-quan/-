package 单链表问题;

public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null){
            return false;
        }
        while( fast.next != null && fast.next.next != null){

            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
