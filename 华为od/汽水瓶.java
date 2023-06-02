package 华为od;

/**
 * @Author shizq18
 * @Date 2023/5/31
 * @Description
 */
public class 汽水瓶 {
    public static void main(String[] args) {
        //System.out.println(solve(3));
        //System.out.println(solve(10));
        System.out.println(solve(81));
    }
    /*输入：
    3
    10
    81
    0
    输出：
    1
    5
    40
    复制
    说明：
    样例 1 解释：用三个空瓶换一瓶汽水，剩一个空瓶无法继续交换
    样例 2 解释：用九个空瓶换三瓶汽水，剩四个空瓶再用三个空瓶换一瓶汽水，剩两个空瓶，向老板借一个空瓶再用三个空瓶换一瓶汽水喝完得一个空瓶还给老板  */
    public static int solve(int n) {
        if (n < 2){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 1;
        }else {
            int countNum = n / 3;
            int leftNum = n % 3;
            return countNum + solve(countNum + leftNum);
        }
    }
}
