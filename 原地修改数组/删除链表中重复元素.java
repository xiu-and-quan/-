package 原地修改数组;

public class 删除链表中重复元素 {
    public ListNode deleteDxiaoDingDuilicates(ListNode head) {
        ListNode newNode=new ListNode(-1);
        newNode.next=head;
        ListNode res=newNode.next;
        ListNode left=head,right=head;
        while (right!=null){
            if (left.val!=right.val){
                left=right;
                res.next=left;
                res=res.next;
            }
            right=right.next;
            if(right==null){
                res.next=null;
            }
        }
        return newNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


