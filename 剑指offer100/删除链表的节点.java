package 剑指offer100;

public class 删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val){
            return head.next;
        }
        ListNode temp = head;
        while (temp.next != null){
            if (temp.next.val == val){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
}
