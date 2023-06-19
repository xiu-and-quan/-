package 华为od;

import java.util.List;
import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/7
 * @Description
 */
public class 输出单向链表中倒数第k个结点 {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.next());
            ListNode head = new ListNode(-1);
            ListNode temp = head;
            //生成链表
            for (int i = 0; i < n; i++) {
                ListNode node = new ListNode(sc.nextInt());
                temp.next = node;
                temp = temp.next;
            }
            int k = Integer.parseInt(sc.next());
            if(getKthFromEnd(head.next,k) != null){
                System.out.println(getKthFromEnd(head.next,k).val);
            }
            else{
                System.out.println(0);
            }

        }*/
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);
        root.next.next.next.next.next.next.next = new ListNode(8);
        System.out.println(getKthFromEnd(root,4));
    }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while (temp != null){
            size++;
            temp = temp.next;
        }
        int direction = size - k;
        while (direction > 0){
            head = head.next;
            direction--;
        }
        return head;
    }

}

class ListNode {
    ListNode next;
    int val;
    ListNode(int val) {
        this.val = val;
        next = null;
    }
}