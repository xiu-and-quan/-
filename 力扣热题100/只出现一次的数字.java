package 力扣热题100;

/**
 * @Author shizq18
 * @Date 2024/1/9
 * @Description
 */
public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        // 相同数字异或
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
