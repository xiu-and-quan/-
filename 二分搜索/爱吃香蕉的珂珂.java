package 二分搜索;

import java.util.Arrays;

public class 爱吃香蕉的珂珂 {
    public static void main(String[] args) {
        int[] piles = new int[]{805306368,805306368,805306368};
        //int res = minEatingSpeed(piles,1000000000);
        System.out.println(canCompleted(piles,2,1000000000));

    }
    /*珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
    珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆
    香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。珂珂喜欢慢慢吃，但仍然想在警
    卫回来前吃掉所有的香蕉。返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。*/
    public static int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = 0;
        for (int item:
             piles) {
            maxSpeed = Math.max(maxSpeed,item);
        }

        //理解为查找左边界
        int left = 1,right = maxSpeed;
        while (left <= right){
            int middle = (left+right)/2;

            System.out.println(left +  "=================" + right );
            System.out.println(middle);
            if (canCompleted(piles,middle,h)){
                right = middle - 1;
            }else {
                left = middle + 1;
            }

        }
        if (canCompleted(piles,left,h) == false || left > maxSpeed){
            return -1;
        }
        return left;
    }
    public static boolean canCompleted(int[] piles,int k,int h){

        long consumeTime = 0;
        for (int item:
             piles) {

            if (k > item){
                consumeTime++;
            }else {
                if (item % k == 0){


                    consumeTime += item / k;

                }else {
                    consumeTime += item / k + 1;
                }
            }

        }

        if (consumeTime <= h){
            return true;
        }else {
            return false;
        }
    }
    public static int minEatingSpeedTest(int[] piles, int h) {
        //吃的速度和需要是时间是反比例，单调递减f(speed)=time;
        int left=1,mid=0,right=1;
        //找右边界
        for (int i = 0; i < piles.length; i++) {
            right=Math.max(right,piles[i]);
        }
        while (left<right){
            mid=(left+right)/2;
            if (getTime(piles,mid)<=h){
                //说明速度太快，需要降低吃的速度
                right=mid;
            }else if (getTime(piles,mid)>h){
                left=mid+1;
            }
        }
        return left;
    }

    private static int getTime(int[] piles, int mid) {
        int h=0;
        for (int i = 0; i < piles.length; i++) {
            int current=(piles[i] + mid - 1) / mid;
            h+=current;
        }
        return h;
    }
}
