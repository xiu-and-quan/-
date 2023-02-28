package 贪心算法;

import java.util.Arrays;

public class ActivitySelection {
    public static void main(String[] args) {
        System.out.println(activitySelection(new int[]{7, 6, 2, 7, 3},
                new int[]{10, 6, 10, 9, 5},5));
    }
    public static int activitySelection(int start[], int end[], int n)
    {
        Activity[] arr = new Activity[n];
        for(int i=0;i<n;i++){
            arr[i] = new Activity(start[i],end[i]);
        }
        Arrays.sort(arr,(x,y)->x.end-y.end);
        int maxStep = 1;
        int frontStep = arr[0].end;
        for (int i = 1; i < n; i++) {
            if (arr[i].start > frontStep){
               maxStep++;
               frontStep = arr[i].end;
            }
        }
        return maxStep;
        // add your code here
        /*int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1;i<n;i++){
            for(int j = 0;j<i;j++){
                if(arr[i].start > arr[j].end){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }else{
                    dp[i] = Math.max(dp[j],dp[i]);
                }
            }
        }
        int maxSelection = 0;
        for(int i=0;i<n;i++){
            maxSelection = Math.max(maxSelection,dp[i]);
        }
        return maxSelection;*/
    }
    public static class Activity{
        int start;
        int end;
        public Activity(int start,int end){
            this.start = start;
            this.end = end;
        }

        public Activity() {
        }
    }
}
