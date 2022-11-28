package 单链表问题;

import java.util.PriorityQueue;

public class 合并k个有序链表队列 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(-1);
        ListNode temp = res;

        PriorityQueue<ListNode> listQueue = new PriorityQueue<>((n1,n2)->n1.val - n2.val);
        for(int i=0;i<lists.length;i++){
            if(lists[i] != null)
                listQueue.add(lists[i]);
        }
        while(!listQueue.isEmpty()){
            ListNode curren = listQueue.poll();
            temp.next = curren;
            temp = temp.next;
            if(curren.next != null){
                listQueue.add(curren.next);
            }
        }
        return res.next;
    }
}
