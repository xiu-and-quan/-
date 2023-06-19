package 华为od;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/14
 * @Description
 */
public class 记票统计 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int size1 = in.nextInt();
        Map<String,Integer> map = new LinkedHashMap<>(size1);
        int invalidCount = 0;
        for (int i = 0; i < size1; i++) {
            map.put(in.next(),0);
        }
        int size2 = in.nextInt();
        for (int i = 0; i < size2; i++) {
            String element = in.next();
            if (map.containsKey(element)) {
                map.put(element,map.get(element)+1);
            }else {
                invalidCount++;
            }
        }
        map.forEach((k,v)->{
            System.out.println(k + " : " + v);
        });
        System.out.println("Invalid : "+invalidCount);
    }
}
