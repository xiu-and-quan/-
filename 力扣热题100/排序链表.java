package 力扣热题100;

import 单链表问题.ListNode;

import java.util.PriorityQueue;

/**
 * @Author shizq18
 * @Date 2023/8/24
 * @Description
 */
public class 排序链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode res = sortList(head);
        System.out.println("success!");
    }
    public static ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> sortQueue = new PriorityQueue<>((x,y)->x.val-y.val);
        while (head != null) {
            sortQueue.add(head);
            head = head.next;
        }
        ListNode root = new ListNode(-1);
        ListNode temp =root;
        while (!sortQueue.isEmpty()) {
            ListNode next = sortQueue.poll();
            temp.next = next;
            temp = temp.next;
        }
        temp.next = null;
        return root.next;
    }

    public static ListNode sortListMerge(ListNode head, ListNode end) {
        if (head == null) {
            return head;
        }
        if (head.next == end) {
            head.next = null;
            return head;
        }
        // 分成两个链表 归并排序 一直分
        // 先找中点 快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (fast != end) {
            fast = fast.next;
            slow = slow.next;
            if (fast != end) {
                fast = fast.next;
            }
        }
        ListNode list1 = sortListMerge(head,slow);
        ListNode list2 = sortListMerge(slow,end);
        return merge(list1, list2);
    }

    private static ListNode merge(ListNode list1, ListNode list2) {
        // 合并链表
        ListNode resNode = new ListNode(0);
        ListNode temp = resNode;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                temp.next = list2;
                list2 =list2.next;
            } else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }
        if (list1 == null) {
            temp.next = list2;
        } else {
            temp.next = list1;
        }
        return resNode.next;
    }
    /*public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }*/
}
