package 华为od;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author shizq18
 * @Date 2023/6/7
 * @Description
 */
public class 杨辉三角 {
    public static void main(String[] args) {
        generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0){
                List<Integer> list = new ArrayList<>();
                list.add(1);
                lists.add(list);
            }else {
                List<Integer> list = new ArrayList<>();
                // 开始和结束
                list.add(1);
                for (int j = 1; j <= 2*i-1; j++) {
                    // j-1 是头顶元素
                    // j-2 是左上角
                    // j 是右上角
                    int left = 0, middle = 0, right = 0;
                    if (j-2 < 0){
                        left = 0;
                    }else {
                        left = lists.get(i-1).get(j-2);
                    }
                    middle = lists.get(i-1).get(j-1);
                    if (j >= lists.get(i-1).size()){
                        right = 0;
                    }else {
                        right = lists.get(i-1).get(j);
                    }
                    list.add(left+middle+right);
                }
                list.add(1);
                lists.add(list);
            }
        }
        return lists;
    }
}
