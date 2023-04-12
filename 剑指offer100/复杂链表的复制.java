package 剑指offer100;

import java.util.HashMap;

public class 复杂链表的复制 {
    /**
     * 深拷贝和浅拷贝
     * 深拷贝是拷贝出相同值的另一个对象
     * 浅拷贝是只是设置一个指针，指向源对象
     */
    HashMap<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        //链表的下一个节点在构建的时候就可以得到
        //关键点在于随机指针指向的链表节点不可能并不存在
        //更像是dfs 先处理下一个节点，在处理随机指针
        if (head == null){
            return null;
        }
        if (!map.containsKey(head)){
            Node headNew = new Node(head.val);
            map.put(head,headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
