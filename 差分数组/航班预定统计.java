package 差分数组;

public class 航班预定统计 {
    /*
    这里有 n 个航班，它们分别从 1 到 n 进行编号。
    有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi]
    意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
    请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
    */
    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] res = new int[n];
            int[] diff = new int[n];
            for(int i = 0; i < bookings.length; i++){
                int start = bookings[i][0] - 1;
                int end = bookings[i][1] - 1;
                int value = bookings[i][2];
                diff[start] += value;
                if(end + 1 < n){
                    diff[end+1] -= value;
                }
            }
            res[0] = diff[0];
            for(int i = 1; i < n; i++){
                res[i] = res[i-1] + diff[i];
            }
            return res;
        }
    }
}
