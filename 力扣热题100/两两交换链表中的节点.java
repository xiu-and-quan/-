package 力扣热题100;

import javafx.beans.value.WritableFloatValue;
import 单链表问题.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author shizq18
 * @Date 2023/8/21
 * @Description
 */
public class 两两交换链表中的节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode resNode = swapPairs(head);
        System.out.println("successful!");
    }
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode preNode = head;
        ListNode currentNode = head;
        ListNode lastNode = head;
        int count = 0, nodeSize = 0;
        while (currentNode != null) {
            count++;
            nodeSize++;
            if (count == 1) {
                preNode = currentNode;
            }
            if (count == 2) {
                currentNode = currentNode;
                count = 0;
                list.add(currentNode);
                list.add(preNode);
            }
            lastNode = currentNode;
            currentNode = currentNode.next;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i == size-1) {
                if (size == nodeSize) {
                    list.get(i).next = null;
                } else {
                    list.get(i).next = lastNode;
                }
            } else {
                list.get(i).next = list.get(i + 1);
            }
        }
        return list.get(0);
    }

    public static ListNode swapPairsRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNextNode = swapPairsRecursion(head.next.next);
        ListNode res = head.next;
        head.next.next = head;
        head.next = nextNextNode;
        return res;
    }

    public static ListNode swapPairsIteration(ListNode head) {
        return null;
    }
}
