package amazon;

import java.util.ArrayList;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3, 4},4,0));
    }
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        // Your code here
        int[] sumArr = invokeSumArray(arr);
        //double pointer
        int left = 0, right = 1;
        while(right <= sumArr.length-1 & left <= right){
            if(sumArr[right] - sumArr[left] < s){
                right++;
            }
            else if(sumArr[right] - sumArr[left] > s){
                left++;
            }
            else{
                ArrayList<Integer> res = new ArrayList<Integer>();
                if (left == right){
                    res.add(-1);
                }else {
                    res.add(left + 1);
                    res.add(right);
                }
                return res;
            }
        }
        ArrayList<Integer> isPossible = new ArrayList<Integer>();
        isPossible.add(-1);
        return isPossible;
    }

    static int[] invokeSumArray(int[] arr){
        int[] arrSum = new int[arr.length+1];
        int sum = 0;
        for(int i = 0; i< arr.length; i++){
            sum += arr[i];
            arrSum[i+1] = sum;
        }
        return arrSum;
    }
}
