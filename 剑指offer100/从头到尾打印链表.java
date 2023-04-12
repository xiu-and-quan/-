package 剑指offer100;

import java.util.ArrayList;

public class 从头到尾打印链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode lastNode = reversePrint(head);
        ArrayList<Integer> list = new ArrayList<>();
        while (lastNode != null){
            list.add(lastNode.val);
            lastNode = lastNode.next;
        }
        int[] res = new int[list.size()];
        for(int i = 0;i< list.size();i++){
            res[i] = list.get(i);
        }
    }
    public static ListNode reversePrint(ListNode head) {
        //反转链表
        //递归
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        //定义为反转链表
        ListNode lastNode = reversePrint(head.next);
        head.next.next = head;
        head.next = null;
        return lastNode;
    }
}
/**
 * Definition for singly-linked list.
 *  */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

    ListNode(){}
 }
