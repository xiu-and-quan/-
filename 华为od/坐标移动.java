package 华为od;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author shizq18
 * @Date 2023/5/30
 * @Description
 */
public class 坐标移动 {
    /*输入：
    A10;S20;W10;D30;X;A1A;B10A11;;A10;
    输出：
    10,-10

    输入：
    ABC;AKL;DA1;
    输出：
    0,0*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        String string = in.nextLine();
        String[] array = string.split(";");
        int length = array.length;
        int[] location = new int[]{0,0};
        Set<Character> repeat = new HashSet<>();
        repeat.add('A');
        repeat.add('D');
        repeat.add('W');
        repeat.add('S');
        for (int i = 0; i < length; i++) {
            if (array[i].length() > 3 || array[i].length() == 0){
                continue;
            }
            if (!repeat.contains(array[i].charAt(0))){
                continue;
            }
            char direction = array[i].charAt(0);
            if (array[i].length() == 2){
                if (array[i].charAt(1) > '9'){
                    continue;
                }
                int distance = array[i].charAt(1)-'0';
                move(location,direction,distance);
            }else {
                if (array[i].charAt(1) > '9' || array[i].charAt(2) > '9'){
                    continue;
                }
                int distance = (array[i].charAt(1)-'0')*10+(array[i].charAt(2)-'0');
                move(location,direction,distance);
            }
        }
        System.out.println(String.valueOf(location[0])+','+String.valueOf(location[1]));
        }

    private static void move(int[] location, char direction, int distance) {
        if (direction == 'A') {
            location[0] -=distance;
        }else if(direction == 'D') {
            location[0] += distance;
        }else if(direction == 'W') {
            location[1] += distance;
        }else {
            location[1] -= distance;
        }
    }
}
