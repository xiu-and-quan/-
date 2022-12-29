package LRU;


import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Map<Integer, Node> map;
    DoubleList LinkedList;
    public int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        LinkedList = new DoubleList(capacity);
    }

    public int get(int key) {
        //o(1)时间复杂度必哈希表  链表配合哈希表
        if(map.containsKey(key)){
            //需要变动链表的位置
            Node node = map.get(key);
            LinkedList.remove(node);
            LinkedList.addLast(node);
            return node.getValue();
        }
        return -1;
    }

    public void put(int key, int value) {
        //o(1)时间复杂度必哈希表

        //存在的情况下需要更新哈希表和链表
        if(map.containsKey(key)){
            //1、先获取旧值，留着链表删除
            Node oldNode = map.get(key);
            //2、更新哈希表
            //3、需要先删除原来链表中的数据，从新添加
            LinkedList.remove(oldNode);


        }else{
            //不存在的情况下
            //1、在map中添加
            map.put(key,new Node(key,value));
            //2、判断是否超出容量
            //超出容量
            if(LinkedList.getSize()==capacity){
                //获取最早的值
                Node firstNode = LinkedList.getFirst();
                //链表删除最旧的值
                LinkedList.removeFirst();
                //哈希表删除最旧的值
                map.remove(firstNode.getKey());
            }
        }
        Node newNode = new Node(key,value);
        //链表中添加值
        LinkedList.addLast(newNode);
        //哈希表中添加值
        map.put(key,newNode);
    }
}