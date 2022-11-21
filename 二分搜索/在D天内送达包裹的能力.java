package 二分搜索;

public class 在D天内送达包裹的能力 {
    public static void main(String[] args) {
        int[] weights = new int[]{3,2,2,4,1,4};
        System.out.println(getHelper(weights,6,3));
    }
    /*传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
     传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
     返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。*/
    public static boolean getHelper(int[] weights, int speed,int days){
        int sum=0;
        int consumerDays=0;
        for(int i=0;i< weights.length;i++){
            sum +=  weights[i];
            if(sum > speed && sum-weights[i]<= speed){
                sum = weights[i];
                consumerDays++;
            }
        }
        if(consumerDays <= days){
            return true;
        }else{
            return false;
        }
    }
}
