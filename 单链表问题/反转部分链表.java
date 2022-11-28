package 单链表问题;

public class 反转部分链表 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(left == 1){
            return reveserLeft(head,right);
        }
        head.next = reverseBetween(head.next,left-1,right-1);
        return head;
    }
    static ListNode nNext = null;
    public static ListNode reveserLeft(ListNode head,int n){
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
