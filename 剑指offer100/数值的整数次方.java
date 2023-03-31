package 剑指offer100;

public class 数值的整数次方 {
    public static void main(String[] args) {
        //System.out.println(myPow(2,-2));
        //double res =Math.pow(0.00001,2147483647);
        System.out.println(powFunction(-3,-2));
    }
    public static double myPow(double x, int n) {
        //base case
        if (x == 0){
            return 0;
        }
        if (n == 0){
            return 1.0;
        }
        if (n<0){
            x = 1/x;
            n = -n;
        }
        //只用考虑n为大于0的情况了
        //判断n为基数还是偶数
        double result = myPow(x*x,n/2);
        if (n % 2 != 0){
            //考虑基数和偶数
            result*=x;
        }
        return result;
    }

    private static double powFunction(double x, int n) {
        if (x == 0){
            return 0;
        }
        if (n == 0){
            return 1.0;
        }
        if (n%2==0){
            return powFunction(x,n/2)*powFunction(x,n/2);
        }else{
            if (n > 0){
                return x*powFunction(x,n/2)*powFunction(x,n/2);
            }else {
                return powFunction(x,n/2)*powFunction(x,n/2)/x;
            }
        }
    }
    public static double power(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        //先计算出half就可以，带入函数就不可以
        double half = power(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else if (n > 0) {
            return half * half * x;
        } else {
            return half * half / x;
        }
    }
}
