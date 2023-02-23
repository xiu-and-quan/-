package amazon;


public class EquilibriumPoint {
    public static void main(String[] args) {
        System.out.println(equilibriumPoint(new long[]{
                4, 42, 27, 16, 28, 3, 4, 5, 9, 3, 31, 5, 5, 29, 10, 18, 35, 35, 33, 19, 41, 23, 8, 32, 9, 5, 8, 18, 35, 13, 6, 7, 6, 10, 11, 13, 37, 2, 25, 7, 28, 43},42));
        System.out.println(equilibriumPoint(new long[]{1,3,5,2,2},5));
    }
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {
        if (n == 1){
            return 1;
        }
        // double point
        // Your code here
        int left = 0, right = n-1;
        long leftSum = arr[0], rightSum = arr[n-1];
        while (left < right){
            if (leftSum >= rightSum){
                right--;
                rightSum += arr[right];
            }else if(leftSum < rightSum){
                left++;
                leftSum += arr[left];
            }
        }
        //System.out.println(left+"    "+leftSum+"   "+right+"    "+ rightSum);
        if (leftSum == rightSum){
            return left+1;
        }else {
            return -1;
        }
    }
}
