package 二分搜索;

public class 左边界{
    public static void main(String[] args) {
        int[] weights = new int[]{1,2,3,1,1};
        //System.out.println(shipWithinDays(weights,4));
        System.out.println(getHelper(weights,1,4));
    }
    public static int shipWithinDays(int[] weights, int days) {
        int left = 1,right = 1, middle = 1;
        for(int i=0;i< weights.length;i++){
            right += weights[i];
        }
        int maxRight = right;
        while(left <= right){
            middle = (left + right)/2;
            if(getHelper(weights,middle,days)){
                right = middle - 1;
            }
            else{
                left = middle + 1;
            }
        }
        if(left >=maxRight || getHelper(weights,left,days) == false ){
            return -1;
        }
        return left;
    }
    public static boolean getHelper(int[] weights, int speed,int days){
        int sum=0;
        int consumerDays=0;
        for(int i=0;i< weights.length;i++){
            sum +=  weights[i];
            if(sum > speed && sum-weights[i]<= speed){
                consumerDays++;
                sum = weights[i];

            }
        }
        if(consumerDays+1 <= days){
            return true;
        }else{
            return false;
        }
    }
}
