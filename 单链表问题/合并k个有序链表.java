package 单链表问题;

import java.util.ArrayList;
import java.util.List;

public class 合并k个有序链表 {
    //时间复杂度高
    public ListNode mergeKLists(ListNode[] lists) {
        //递归
        if (lists.length < 1){
            return null ;
        }
        if (lists.length < 2){
            return lists[0] ;
        }
        ListNode first = mergeTwoLists(lists[0],lists[1]);

        for (int i = 2; i < lists.length; i++) {
            first = mergeTwoLists(first,lists[i]);
        }
        return first;
    }
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
