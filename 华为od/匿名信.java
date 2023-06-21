package 华为od;

import javax.print.DocFlavor;
import java.util.*;

/**
 * @Author shizq18
 * @Date 2023/6/20
 * @Description
 */
public class 匿名信 {
    public static void main(String[] args) {
        System.out.println(solve(new String[]{"ab","bcd","ef"}, new String[]{"cbd","fe"}));
    }
    public static boolean solve(String[] strings1, String[] strings2) {
        int length1 = strings1.length;
        int length2 = strings2.length;
        if (length2 > length1) {
            return false;
        }
        /*String[] list1 = new String[length1];
        String[] list2 = new String[length2];*/
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        String str = null;
        for (int i = 0; i < length1; i++) {
            char[] current = strings1[i].toCharArray();
            Arrays.sort(current);
            str = String.valueOf(current);
            map1.put(str, map1.getOrDefault(str,0)+1);
        }
        for (int i = 0; i < length2; i++) {
            char[] current = strings2[i].toCharArray();
            Arrays.sort(current);
            str = String.valueOf(current);
            map2.put(str, map2.getOrDefault(str,0)+1);
        }
        Iterator<Map.Entry<String, Integer>> entrys = map2.entrySet().iterator();
        while (entrys.hasNext()) {
            Map.Entry<String, Integer> currentElement= entrys.next();
            if (!map1.containsKey(currentElement.getKey()) || map1.get(currentElement.getKey()) != currentElement.getValue()) {
               return false;
            }
        }
        return true;
    }
}
