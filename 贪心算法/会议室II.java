package 贪心算法;

import java.util.Arrays;

public class 会议室II {
    public static void main(String[] args) {
        int[][] meetings = new int[][]{{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(meetings));
    }
    // 返回需要申请的会议室数量
    static int minMeetingRooms(int[][] meetings){
        //差分数组
        //找最大值确定数组长度
        int size = meetings.length;
        int maxSize = 0;
        for (int i = 0; i < size; i++) {
            maxSize = Math.max(maxSize,meetings[i][1]);
        }
        int[] array = new int[maxSize+1];
        for (int i = 0; i < size; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            array[start]++;
            array[end]--;
        }
        for (int i = 1; i <= maxSize; i++) {
            array[i] = array[i] + array[i-1];
        }
        int maxRes = 0;
        for (int i = 1; i <= maxSize; i++){
            maxRes = Math.max(maxRes,array[i]);
        }
        return maxRes;
    }
}
class Helper{
    int start;
    int end;
    public Helper(int start,int end){
        this.start = start;
        this.end = end;
    }
}
