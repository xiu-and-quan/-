package 单链表问题;

public class 两个链表找相同部分的起点 {
    public static ListNode findSameStart(ListNode n1,ListNode n2){
        ListNode left = n1;
        ListNode right = n2;
        while (left != right){
            if (left == null){
                left = n2;
            }else {
                left = left.next;
            }
            if (right == null){
                right = n1;
            }else {
                right = right.next;
            }
        }
        return left;
    }
}
