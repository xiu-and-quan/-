package LRU;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMap {
    LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap<>();
    int capacity;
    public LRULinkedHashMap(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        //o(1)时间复杂度必哈希表  链表配合哈希表
        if(linkedHashMap.containsKey(key)){
            //更新完，需要将更新的值更新为最新的
            int value = linkedHashMap.get(key);
            makeRecently(key,value);
            return value;
        }
        return -1;
    }

    /*
    * 更新key的排序位置*/
    private void makeRecently(int key,int value) {
        linkedHashMap.remove(key);
        linkedHashMap.put(key,value);
    }

    public void put(int key, int value) {
        //o(1)时间复杂度必哈希表
        if (linkedHashMap.containsKey(key)){
            //linkedHashMap 如果值存在，只会更新值，不会变动链表的排序的
            linkedHashMap.put(key,value);
            makeRecently(key, value);
        }else {
            if (linkedHashMap.size() == capacity){
                //链表头后一个就是最旧的数据
                Map.Entry<Integer, Integer> oldElement = linkedHashMap.entrySet().iterator().next();
                //删除旧数据
                linkedHashMap.remove(oldElement.getKey());
                //添加新数据
                linkedHashMap.put(key,value);
            }else {
                linkedHashMap.put(key,value);
            }
        }
    }
}
