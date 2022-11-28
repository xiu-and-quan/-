package 单链表问题;

public class 反转链表前n个节点 {
    ListNode nNext = null;
    public ListNode reveserLeft(ListNode head,int n){
        //只要n为1就可以
        if (n == 1){
            nNext= head.next;
            return head;
        }
        ListNode reveserTemp = reveserLeft(head.next,n-1);
        head.next.next = head;
        head.next = nNext;
        return reveserTemp;
    }
}
