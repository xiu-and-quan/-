package 牛客剑指;

/**
 * @Author shizq18
 * @Date 2023/8/4
 * @Description
 */
public class 除自身以外数组的乘积 {
    public static void main(String[] args) {
        int[] res = productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println("success");
    }
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        int temp = 1;
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }
        for (int i = length-2; i >= 0; i--) {
            temp *= nums[i+1];
            answer[i] = answer[i]*temp;
        }
        return answer;
    }
}
