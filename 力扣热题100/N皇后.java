package 力扣热题100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author shizq18
 * @Date 2023/10/11
 * @Description
 */
public class N皇后 {
    public static void main(String[] args) {
//        solveNQueens(4);
        char[][] path = new char[][]{{',','Q',',',','},
                {',','.',',','Q'},
                {',','.','Q',','},
                {'Q','.',',',','}
        };
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            stringList.add(new String(path[i]));
        }
//        List<String> stringList = Arrays.stream(path)
//                .map(String::new)
//                .collect(Collectors.toList());
        System.out.println(vaild(path,2,2));
    }
    static List<List<String>> resList = new ArrayList<>();
    public static List<List<String>> solveNQueens(int n) {
        // 每一行放置某一列
        char[][] path = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(path[i], '.');
        }
        traver(n, path, 0);
        System.out.println("path");
        return null;
    }

    private static void traver(int n, char[][] path, int start) {
        if (start == n) {
            List<String> stringList = Arrays.stream(path)
                    .map(String::new)
                    .collect(Collectors.toList());
            resList.add(stringList);
            return;
        }
        // 从每行的第0列往后放
        for (int i = 0; i < n; i++) {
            // 放置棋子
            path[start][i] = 'Q';
            if (vaild(path,start,i)) {
                traver(n, path, start+1);
            }
            // 撤销选择
            path[start][i] = '.';
        }
    }

    /**
     * 判断合法性
     */
    private static boolean vaild(char[][] path, int row, int col) {
        // 左上
        for (int i = row-1, j = col-1; i >= 0 && j >= 0 ; i--, j--) {
            if (path[i][j] == 'Q') {
                return false;
            }
        }
        //右上
        for (int i = row-1, j = col+1; i >= 0 && j < path.length ; i--, j++) {
            if (path[i][j] == 'Q') {
                return false;
            }
        }
        //上面
        for (int i = 0; i < row; i++) {
            if (path[i][col] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
