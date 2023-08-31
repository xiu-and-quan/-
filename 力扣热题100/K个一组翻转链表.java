package 力扣热题100;

import 单链表问题.ListNode;

import java.awt.*;

/**
 * @Author shizq18
 * @Date 2023/8/23
 * @Description
 */
public class K个一组翻转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode res = reverseGroup(head, 2);
        System.out.println("success");
    }

    /**
     * 反转前n个链表
     * @param head
     * @return
     */
    static ListNode endNode;
    public static ListNode backBefore(ListNode head, int right) {
        if (right == 1) {
            endNode = head.next;
            return head;
        }
        ListNode next = backBefore(head.next,right-1);
        head.next.next = head;
        head.next = endNode;
        return next;
    }
    public static ListNode reverseGroup(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (size < k) {
            return head;
        }
        ListNode res = reverseIJ(head,1,k);
        for (int i = 2*k; i <= size; i+=k) {
            reverseIJ(res,i-k+1,i);
        }
        return  res;
    }
    public static ListNode reverseIJ(ListNode head, int i, int j) {
        if (i == 1){
            return backBefore(head, j);
        }
        head.next = reverseIJ(head.next,i-1,j-1);
        return head;
    }


    private ListNode help(ListNode head, int k, int size) {
        int count = k;
        if (size < k) {
            return head;
        }
        ListNode pre = null;
        ListNode current = head;
        while (count >= 0) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        help(head, k ,size-k);
        return null;
    }
}
