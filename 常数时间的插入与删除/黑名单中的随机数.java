package 常数时间的插入与删除;

import java.util.*;

public class 黑名单中的随机数 {
    Map<Integer, Integer> b2w;
    Random random;
    int size;
    public void 常数时间插入删除和获取随机元素(int n, int[] blacklist) {
    b2w = new HashMap<Integer, Integer>();
    random = new Random();
    size = n - blacklist.length;
    Set<Integer> black = new HashSet<Integer>();
        for (int b : blacklist) {
        if(b>=size)
            black.add(b);
    }
    int start = size;
        for (int b : blacklist) {
        if(b<size){
            while(black.contains(start)){
                start++;
            }
            b2w.put(b,start);
            start++;
        }
    }

}

    public int pick() {
        int x = random.nextInt(size);
        if(b2w.containsKey(x)){
            return b2w.get(x);
        }else{
            return x;
        }
    }
}
