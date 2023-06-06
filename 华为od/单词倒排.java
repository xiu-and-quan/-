package 华为od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/6
 * @Description
 */
public class 单词倒排 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String string = in.nextLine();
        int totalLength = string.length();
        List<String> list = new ArrayList<>();
        int left = 0, right = 0;
        while (right < totalLength) {
            if ((string.charAt(right) >= 'a' && string.charAt(right) <= 'z')
                || (string.charAt(right) >= 'A' && string.charAt(right) <= 'Z')) {
                if (right == totalLength-1){
                    list.add(string.substring(left,right+1));
                }
                right++;
            }else {
                if (left != right) {
                    list.add(string.substring(left, right));
                }
                left = right + 1;
                right++;
            }
        }
        int length = list.size();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = length-1; i >= 0; i--) {
            stringBuilder.append(list.get(i));
            if (i != 0) {
                stringBuilder.append(" ");
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
