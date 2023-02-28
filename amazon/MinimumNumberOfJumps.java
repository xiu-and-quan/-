package amazon;

import java.util.Arrays;

public class MinimumNumberOfJumps {
    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
    }
    static int minJumps(int[] arr){
        // your code here
        if (arr[0] == 0){
            return -1;
        }
        int size = arr.length;
        int[] memo = new int[size];
        Arrays.fill(memo,-2);
        return helperFunction(arr,0,arr[0],memo);
    }

    private static int helperFunction(int[] arr,int index, int value,int[] memo) {
        if (value == 0){
            return memo[index] = -1;
        }
        if (memo[index] != -2){
            return memo[index];
        }
        int minJumps = Integer.MAX_VALUE;
        for (int i = 1; i <= value; i++) {
            if (index + i >= arr.length-1){
                return 1;
            }else {
                int resJump = helperFunction(arr, index + i, arr[i + index],memo);
                if (resJump == -1){
                    continue;
                }
                minJumps = Math.min(minJumps, resJump + 1);
            }
        }
        return memo[index] = minJumps == Integer.MAX_VALUE ? -1 :minJumps;
    }
}
