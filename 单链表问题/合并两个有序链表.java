package 单链表问题;

public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //双指针问题
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list1 == null){
            temp.next = list2;
        }
        if(list2 == null){
            temp.next= list1;
        }
        return res.next;
    }
}


