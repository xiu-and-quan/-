package 力扣热题100;

import 单链表问题.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author shizq18
 * @Date 2023/8/18
 * @Description
 */
public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int size = list.size();
        int left = 0, right = size - 1;
        while (left <= right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}