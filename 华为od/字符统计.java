package 华为od;

import java.util.*;

/**
 * @Author shizq18
 * @Date 2023/6/14
 * @Description
 */
public class 字符统计 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String string = in.next();
            int size = string.length();
            Map<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < size; i++) {
                char element = string.charAt(i);
                map.put(string.charAt(i),map.getOrDefault(element,0)+1);
            }
            List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
            list.sort((o1, o2) -> {
                if (o2.getValue() != o1.getValue()) {
                    return o2.getValue() - o1.getValue();
                }else {
                    return o1.getKey() - o2.getKey();
                }
            });
            StringBuilder builder = new StringBuilder();
            for (Map.Entry<Character, Integer> mapping : list) {
                builder.append(mapping.getKey());
            }
            System.out.println(builder.toString());
        }
    }
}
