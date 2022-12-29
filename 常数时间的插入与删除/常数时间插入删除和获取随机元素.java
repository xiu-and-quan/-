package 常数时间的插入与删除;

import java.util.*;

public class 常数时间插入删除和获取随机元素 {
    public static void main(String[] args) {
        List<Map<Integer,Integer>> list = new ArrayList<>();
        Map<Integer,Integer> map1 = new HashMap<>();
        map1.put(1,1);
        map1.put(2,2);
        Map<Integer,Integer> map2 = new HashMap<>();
        map1.put(3,3);
        map1.put(4,4);
        list.add(map1);
        list.add(map2);
        list.forEach(r -> {
            Iterator<Map.Entry<Integer, Integer>> entrySet = r.entrySet().iterator();
            while (entrySet.hasNext()){
                Map.Entry<Integer, Integer> currentElement = entrySet.next();
                System.out.println(currentElement.getKey() +"================"+ currentElement.getValue());
            }
        });
        
    }
}
class RandomizedSet {

    //链表配合散列表 类似linkedHashMap
    HashMap<Integer,Integer> map;
    ArrayList<Integer> list;
    int index;
    public RandomizedSet() {
        this.map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (map.containsKey(val)){

            int indexValue = map.get(val);

            //1.2 删除list的
            //不是真正意义的删除，想要复杂度低就得交换，只有数组插入在最后位置才是快
            int lastElement = list.get(list.size()-1);
            list.set(indexValue,lastElement);
            //删除最后的元素
            list.remove(list.size()-1);
            //删除list里面的，还需要更新map里面的数据
            map.put(lastElement,indexValue);
            //1.1 删除map的 放在这就可以防止删除的时候只有它自身一个元素，防止重复添加map
            map.remove(val);

            return true;
        }else {
            return false;
        }
    }

    public int getRandom() {
        Random random = new Random();
        int n = random.nextInt(list.size());
        return list.get(n);
    }
}
