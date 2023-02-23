package amazon;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{1,2,3,-2,5},4));
    }
    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    static long maxSubarraySum(int arr[], int n){

        // Your code here
        int[] dp = arr;
        //dp[i]:求的是当前数组的任意个连续子数组的最大和
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue,dp[i]);
        }
        return maxValue;
    }
}
