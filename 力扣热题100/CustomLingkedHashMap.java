package 力扣热题100;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author shizq18
 * @Date 2023/8/28
 * @Description LRU缓存
 */
class TestLRU{
    public static void main(String[] args) {
        CustomLingkedHashMap lRUCache = new CustomLingkedHashMap(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
}
public class CustomLingkedHashMap {
    int capacity;

    HashMap<Integer, CustomLinkedList.CustomNode> keyToNode;
    CustomLinkedList customLinkedList;

    public CustomLingkedHashMap(int capacity) {
        this.capacity = capacity;
        keyToNode = new HashMap<>();
        customLinkedList = new CustomLinkedList(capacity);
    }

    public int get(int key) {
        if (keyToNode.containsKey(key)) {
            CustomLinkedList.CustomNode res = keyToNode.get(key);
            makeRecently(res);
            return res.value;
        }
        return -1;
    }

    /*
     * 更新key的排序位置*/
    private void makeRecently(CustomLinkedList.CustomNode node) {
        customLinkedList.removeNode(node);
        customLinkedList.addLast(node);
    }

    public void put(int key, int value) {
        if (keyToNode.containsKey(key)) {
            CustomLinkedList.CustomNode res = keyToNode.get(key);
            res.setValue(value);
            makeRecently(res);
        } else {
            if (customLinkedList.size >= capacity) {
                CustomLinkedList.CustomNode first = customLinkedList.getFirst();
                customLinkedList.removeFirst();
                keyToNode.remove(first.getKey());
            }
            CustomLinkedList.CustomNode res = new CustomLinkedList.CustomNode(key,value);
            keyToNode.put(key,res);
            customLinkedList.addLast(res);
        }
    }
}
class CustomLinkedList{
    int size;
    CustomNode head;
    CustomNode tail;

    int capacity;
    public CustomLinkedList(int capacity) {
        head = new CustomNode(0,0);
        tail = new CustomNode(0,0);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
        size = 0;
    }
    public void addLast(CustomNode e) {
        tail.pre.next = e;
        e.pre = tail.pre;
        e.next = tail;
        tail.pre = e;
        size++;
    }
    public void removeNode(CustomNode e) {
        e.pre.next = e.next;
        e.next.pre = e.pre;
        size--;
    }
    public void removeFirst(){
        head.next.next.pre = head;
        head.next = head.next.next;
        size--;
    }
    public int getSize(){
        return size;
    }

    public CustomNode getFirst() {
        return head.next;
    }
    static class CustomNode{

        Integer key;
        Integer value;
        CustomNode pre;
        CustomNode next;

        public CustomNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public CustomNode(CustomNode pre, Integer value,CustomNode next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }
    }
}
