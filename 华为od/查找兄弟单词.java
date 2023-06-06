package 华为od;

import 剑指offer100.二叉树的最近公共祖先;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/6
 * @Description
 */
public class 查找兄弟单词 {
    /*输入只有一行。 先输入字典中单词的个数n，再输入n个单词作为字典单词。 然后输入一个单词x 最后后输入一个整数k*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int length = in.nextInt();
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = in.next();
        }
        String resource = in.next();
        int sortIndex = in.nextInt();
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < length; i++) {
            if (!resource.equals(strings[i])){
                sortIndex--;
                if (sortIndex == 0) {
                    System.out.println(i);
                    System.out.println(strings[i]);
                }
            }

        }
    }
}
