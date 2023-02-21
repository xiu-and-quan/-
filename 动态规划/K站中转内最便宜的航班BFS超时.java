package 动态规划;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class K站中转内最便宜的航班BFS超时 {
    public static void main(String[] args) {
        System.out.println(findCheapestPrice(3,new int[][]{{0,1,100},{1,2,100},{0,2,500}},0,2,1));;
    }
    /*输入:
    n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
    src = 0, dst = 2, k = 1
    输出: 200*/
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //bfs
        ArrayList<Integer> resList = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        HashMap<Integer,ArrayList<int[]>> startToValue = new HashMap<>();
        for (int[] element:
             flights) {
            startToValue.putIfAbsent(element[0],new ArrayList<int[]>());
            startToValue.get(element[0]).add(element);
        }
        if (src == dst){
            return 0;
        }
        for (int[] element:
             startToValue.get(src)) {
            queue.add(element);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                if (current[1] == dst){
                    resList.add(current[2]);
                    continue;
                }
                for (int[] element:startToValue.get(current[1])) {
                    queue.add(new int[]{element[0],element[1],element[2]+current[2]});
                }
            }
        }
        if (resList.size() == 0){
            return -1;
        }
        int minDistance = Integer.MAX_VALUE;
        for (int element:
             resList) {
            minDistance = Math.min(element,minDistance);
        }
        return minDistance;
    }
}
