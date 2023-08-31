package 牛客剑指;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author shizq18
 * @Date 2023/8/3
 * @Description
 */
public class 合并区间 {
    public static void main(String[] args) {
        // int[][] res = merge(new int[][]{{1, 4}, {0, 4}, {8, 10}, {15, 18}});
        int[][] res = merge(new int[][]{{1, 4}, {0, 4}});
        System.out.println(res);
    }
    /*
    * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    输出：[[1,6],[8,10],[15,18]]
    解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].*/
    public static int[][] merge(int[][] intervals) {
        // 排序
        Arrays.sort(intervals,(x,y)->x[0]-y[0]);
        int length = intervals.length;
        List<int[]> resList = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];

        for (int i = 1; i < length; i++) {

            if (intervals[i][0] <= end) {
                if (end > intervals[i][1]) {
                    continue;
                } else {
                    end = intervals[i][1];
                }
            } else {
                resList.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        resList.add(new int[]{start,end});
        int[][] resArray = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            resArray[i] = resList.get(i);
        }
        return resArray;
    }
}
