package 剑指offer100;

/**
 * @Author shizq18
 * @Date 2023/5/4
 * @Description
 */
public class 数组中数字出现的次数II {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{3,4,3,3}));
    }

    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     * @param nums
     * @return res
     */
    public static int singleNumber(int[] nums) {
        // 思路：对二进制的每一个位置都求和然后除以3，就可以得到单次数的数
        // 因为出现三次的数的位置是都是二进制1，三次就正好抵消掉了
        int size = nums.length;
        int[] binaryArry = new int[32];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 32; j++) {
                //取到最右边的二进制位
                binaryArry[j] += nums[i] & 1;
                //右移一位 取到上一位
                nums[i] = nums[i] >>> 1;
            }
        }
        // 取余
        for (int i = 0; i < 32; i++) {
            binaryArry[i] = binaryArry[i] % 3;
        }
        //恢复数字 位置是相反的
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= binaryArry[31 - i] % m;
        }
        return res;
    }
}
