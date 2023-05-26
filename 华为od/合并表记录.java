package 华为od;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/5/25
 * @Description
 */
public class 合并表记录 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        solve(new int[][]{{0,1},{0,2},{1,2}});
    }
    public static void solve(int[][] numsArray){
        Scanner scanner = new Scanner(System.in);
        int tableSize = scanner.nextInt();
        Map<Integer, Integer> table = new HashMap<>(tableSize);
        for (int i = 0; i < tableSize; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            if (table.containsKey(key)) {
                table.put(key, table.get(key) + value);
            } else {
                table.put(key, value);
            }
        }
        for (Integer key : table.keySet()) {
            System.out.println( key + " " + table.get(key));
        }
    }
}
