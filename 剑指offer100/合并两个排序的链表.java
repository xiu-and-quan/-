package 剑指offer100;

public class 合并两个排序的链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(1);
        ListNode temp = res;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 == null){
            temp.next = l2;
        }else {
            temp.next = l1;
        }
        return res.next;
    }
}
