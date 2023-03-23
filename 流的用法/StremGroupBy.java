package 流的用法;

import java.util.*;
import java.util.stream.Collectors;

public class StremGroupBy {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}};
        int size = intervals.length;
        List<Activity> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new Activity(intervals[i][0], intervals[i][1]));
        }
        HashMap<Integer, Integer> res = new HashMap<>();
        list.stream().collect(Collectors.groupingBy(e -> e.start))
                .forEach((k, v) -> {
                    res.put(k, v.stream().collect(Collectors.summingInt(e -> e.end)));
                });
        Iterator<Map.Entry<Integer, Integer>> iterator = res.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //流的reduce方法
        List<Integer> reduceTestList = new ArrayList<>();
        reduceTestList.add(1);
        reduceTestList.add(2);
        reduceTestList.add(3);
        Integer reduceTestRes = reduceTestList.stream().reduce((x, y) -> x + y).get();
        System.out.println(reduceTestRes);
    }
}
class Activity{
    int start;
    int end;
    public Activity(int start,int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
