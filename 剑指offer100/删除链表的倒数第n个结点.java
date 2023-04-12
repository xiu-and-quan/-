package 剑指offer100;

public class 删除链表的倒数第n个结点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        removeNthFromEnd(head,2);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //先测试head的总长度
        ListNode tempNodeUsedMethodLength = head;
        int totalSize = 0;
        while (tempNodeUsedMethodLength != null){
            tempNodeUsedMethodLength = tempNodeUsedMethodLength.next;
            totalSize++;
        }
        int forwardDirection = totalSize-n;
        if (forwardDirection == 0){
            return null;
        }
        ListNode temp = head;
        while (forwardDirection != 1){
            temp = temp.next;
            forwardDirection--;
        }
        temp.next = temp.next.next;
        return head;
    }
}
