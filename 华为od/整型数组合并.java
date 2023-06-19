package 华为od;

import java.util.*;

/**
 * @Author shizq18
 * @Date 2023/6/9
 * @Description
 */
public class 整型数组合并 {
    /*输入：
    3
    1 2 5
    4
    -1 0 3 2
    复制
    输出：
    -101235*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int length1 = in.nextInt();
        int[] array1 = new int[length1];
        for (int i = 0; i < length1; i++) {
            array1[i] = in.nextInt();
        }
        int length2 = in.nextInt();
        int[] array2 = new int[length2];
        for (int i = 0; i < length2; i++) {
            array2[i] = in.nextInt();
        }
        System.out.println((solve(array1, array2)));
    }

    public static String solve(int[] array1, int[] array2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array1.length; i++) {
            set.add(array1[i]);
        }
        for (int i = 0; i < array2.length; i++) {
            set.add(array2[i]);
        }
        int[] resArray = new int[set.size()];
        int index = 0;
        for (int element:
             set) {
            resArray[index++] = element;
        }
        Arrays.sort(resArray);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < set.size(); i++) {
            stringBuilder.append(resArray[i]);
        }
        return stringBuilder.toString();
    }
}