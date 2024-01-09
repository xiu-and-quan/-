package 力扣热题100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author shizq18
 * @Date 2023/12/8
 * @Description
 */
public class 杨辉三角 {
    public static void main(String[] args) {
        List<List<Integer>> res = generate(5);
        System.out.println(res.toString());
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 1) {
                list.add(1);
            } else if (i == 2) {
                list.add(1);
                list.add(1);
            } else {
                list.add(1);
                for (int j = 0; j < i-2; j++) {
                    list.add(resList.get(i-2).get(j) + resList.get(i-2).get(j+1));
                }
                list.add(1);
            }
            resList.add(list);
        }
        return resList;
    }
}
