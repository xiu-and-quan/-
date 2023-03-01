package 贪心算法;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class 无重叠区间 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2},{1,3},{2,3},{2,4}};
        //eraseOverlapIntervals(intervals);
        int size = intervals.length;
        List<Activity> list = new ArrayList<>();
        for(int i=0;i<size;i++){
            list.add(new Activity(intervals[i][0],intervals[i][1]));
        }
        HashMap<Integer,Integer> res = new HashMap<>();
        list.stream().collect(Collectors.groupingBy(e -> e.start))
                .forEach((k, v) -> {
                    res.put(k,v.stream().collect(Collectors.summingInt(e ->e.end)));
                });
        Iterator<Map.Entry<Integer, Integer>> iterator = res.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        int size = intervals.length;
        Activity[] arr = new Activity[size];
        for(int i=0;i<size;i++){
            arr[i] = new Activity(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(arr,(x, y)->x.end - y.end);
        int needRemoveCount = 0;
        int current = arr[0].end;
        for(int i=1;i<size;i++){
            if (arr[i].start > current){
                needRemoveCount++;
            }
        }
        return needRemoveCount;
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
