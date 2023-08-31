package 牛客剑指;

import 二分搜索.爱吃香蕉的珂珂;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @Author shizq18
 * @Date 2023/7/13
 * @Description
 */
public class 把数组排成最小的数 {
    public static void main(String[] args) {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("11");
//        System.out.println(stringBuilder.length());
        String res = PrintMinNumber(new int[]{11,3});
        System.out.println(res);
    }
    public static String PrintMinNumberResolve (int[] numbers) {
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strings,(a1,a2)->(a1+a2).compareTo(a2+a1));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            stringBuilder.append(strings[i]);
        }
        return stringBuilder.toString();
    }
    static List<List<String>> stringList = new ArrayList<>();
    public static String PrintMinNumber (int[] numbers) {
        // write code here
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }
        boolean[] isVisited = new boolean[strings.length];
        traver(strings,new ArrayList<String>(),isVisited);
        List<String> resList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringList.forEach(e -> {
            e.forEach(ie -> stringBuilder.append(ie));
            resList.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        });
        resList.sort((a1,a2)->a1.compareTo(a2));
        return resList.get(0);
    }

    private static void traver(String[] strings, ArrayList<String> arrayList, boolean[] isVisited) {
        // base case
        if(arrayList.size() == strings.length) {
            stringList.add(new ArrayList<>(arrayList));
            return;
        }
        for (int i = 0; i < strings.length; i++) {
            if (!isVisited[i]) {
                // 加入路径
                isVisited[i] = true;
                arrayList.add(strings[i]);
                // 下一次选择
                traver(strings, arrayList, isVisited);
                // 撤销选择
                isVisited[i] = false;
                arrayList.remove(arrayList.size()-1);
            }
        }
    }
}
