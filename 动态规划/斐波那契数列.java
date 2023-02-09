package 动态规划;

public class 斐波那契数列 {
    public static void main(String[] args) {
        System.out.println(fib(45));
    }
    public static int fib(int n) {
        int[] nums = new int[n+1];
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        nums[0] = 0;
        nums[1] = 1;
        //遍历
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums[n];
    }
}
