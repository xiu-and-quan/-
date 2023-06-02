package 华为od;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/5/26
 * @Description
 */
public class 字符串排序 {
    public static void main(String[] args) {
        String[] strings = new String[]{"a","b","c"};
        Arrays.sort(strings,(a,b)->b.compareTo(a));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b)->b-a);
        System.out.println(Arrays.toString(strings));

        /*System.out.println(Arrays.toString(solve(9, new String[]{"cap"
                ,"to"
                ,"cat"
                ,"card"
                ,"two"
                ,"too"
                ,"up"
                ,"boat"
                ,"boot"})));*/
    }
    /*给定 n 个字符串，请对 n 个字符串按照字典序排列。*/
    public static String[] solve(int length, String[] strings) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < length; i++) {
            priorityQueue.add(strings[i]);
        }
        String[] stringArray = new String[length];
        for (int i = 0; i < length; i++) {
            stringArray[i] = priorityQueue.poll();
        }
        return stringArray;
    }
}
