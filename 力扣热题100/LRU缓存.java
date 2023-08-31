package 力扣热题100;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author shizq18
 * @Date 2023/8/28
 * @Description
 */
public class LRU缓存 {
}
class LRUCache {
    int capacity;
    LinkedHashMap<Integer,Integer> linkedHashMap;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        linkedHashMap = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        if (linkedHashMap.containsKey(key)) {
            int res = linkedHashMap.get(key);
            makeRecently(key,res);
            return res;
        }
        return -1;
    }

    /*
     * 更新key的排序位置*/
    private void makeRecently(int key,int value) {
        linkedHashMap.remove(key,value);
        linkedHashMap.put(key,value);
    }

    public void put(int key, int value) {
        if (linkedHashMap.containsKey(key)) {
            linkedHashMap.remove(key);
        } else {
            if (linkedHashMap.size() >= capacity) {
                Map.Entry<Integer, Integer> firstElement = linkedHashMap.entrySet().iterator().next();
                linkedHashMap.remove(firstElement.getKey(),firstElement.getValue());
            }
        }
        makeRecently(key,value);
    }
}
