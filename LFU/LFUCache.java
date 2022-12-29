package LFU;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;

class LFUCache {

    //两个linkedHashMap
    //两个key分别为key，另一个为数量
    HashMap<Integer,Integer> keyMappedValue;
    HashMap<Integer,Integer> keyMappedFreq;
    //count对应的key集合
    HashMap<Integer, LinkedHashSet<Integer>> freqMappedKeys;
    //capacity
    int capacity;

    //minFreq
    int minFreq;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyMappedValue = new HashMap<>();
        keyMappedFreq = new HashMap<>();
        freqMappedKeys = new HashMap<>();
    }

    public int get(int key) {
        if (keyMappedValue.containsKey(key)){
            //增加该key使用的freq
            increaseFreq(key);
            //返回value
            return keyMappedValue.get(key);
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (keyMappedValue.containsKey(key)){
            //修改 keyMappedValue
            keyMappedValue.put(key,value);
            increaseFreq(key);
            //增加该key使用的freq
        }else {
            //容量有没有满
            if (capacity == keyMappedValue.size()){
                //满的情况 清除最久的数据
                removeOldestKey();
            }
            //增加 keyMappedValue
            keyMappedValue.put(key,value);
            //增加该key使用的freq
            keyMappedFreq.put(key,1);
            //插入freqMappedKeys
            freqMappedKeys.getOrDefault(1,new LinkedHashSet<>()).add(key);
            //更新最小的minFreq
            this.minFreq = 1;
        }
    }

    private void removeOldestKey() {
        //1、删除最早插入的数据 freqMappedKeys
        //freq最小的key列表
        LinkedHashSet<Integer> keyList = freqMappedKeys.get(this.minFreq);
        //最先被插入的就是最旧的数据
        int firstKey = keyList.iterator().next();
        keyList.remove(firstKey);
        if (keyList.isEmpty()){
            freqMappedKeys.remove(this.minFreq);
        }
        //2、删除keyMappedValue
        keyMappedValue.remove(firstKey);
        //3、删除keyMappedFreq
        keyMappedFreq.remove(firstKey);
    }

    private void increaseFreq(int key) {
        //1、增加该key使用的freq
        int freq = keyMappedFreq.getOrDefault(key,0);
        keyMappedFreq.put(key,freq+1);
        //2、更新freqMappedKeys
        //2.1 删除原来keyList中的key
        freqMappedKeys.get(freq).remove(key);
        //2.2 增加ferq+1 中的keysList
        freqMappedKeys.getOrDefault(freq+1,new LinkedHashSet<>()).add(key);
        //如果删除了该元素后，keysList空了就删除
        if (freqMappedKeys.get(freq).isEmpty()){
            freqMappedKeys.remove(freq);
            if (freq == this.minFreq){
                minFreq++;
            }
        }
    }
}