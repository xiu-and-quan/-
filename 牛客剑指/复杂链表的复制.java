package 牛客剑指;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author shizq18
 * @Date 2023/7/5
 * @Description
 */
public class 复杂链表的复制 {
    public static void main(String[] args) {
        RandomListNode root = new RandomListNode(1);
        root.next = new RandomListNode(2);
        root.next.next = new RandomListNode(3);
        root.next.next.next = new RandomListNode(4);
        root.next.next.next.next = new RandomListNode(5);

        root.random = root.next.next;
        root.next.random = root.next.next.next.next;
        root.next.next.next.random = root.next;

        RandomListNode res = Clone(root);
        System.out.println("success");
    }
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 先处理顺序节点然后处理随机节点
        // 头节点
        Map<RandomListNode, RandomListNode> randomToRandom = new HashMap<>();
        RandomListNode rootRes = new RandomListNode(pHead.label);
        help(randomToRandom,pHead,rootRes);
        return rootRes;
    }

    private static void help(Map<RandomListNode, RandomListNode> randomToRandom, RandomListNode pHead, RandomListNode rootRes) {
        if (pHead == null){
            return;
        }
        randomToRandom.put(pHead,rootRes);
        if (pHead.next != null) {
            rootRes.next = new RandomListNode(pHead.next.label);
        }
        help(randomToRandom,pHead.next,rootRes.next);
        rootRes.random = randomToRandom.get(pHead.random);
    }
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
