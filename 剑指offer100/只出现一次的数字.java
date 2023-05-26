package 剑指offer100;

/**
 * @Author shizq18
 * @Date 2023/5/15
 * @Description
 */
public class 只出现一次的数字 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 3, 2}));
    }
    public static int singleNumber(int[] nums) {
        // 统计32位二进制出现的次数之和然后取余。出现三次的就会被筛选掉
        int size = nums.length;
        int[] binaryArray = new int[32];
        int binaryOne = 1;
        for (int i = 0; i < size; i++) {
            binaryOne = 1;
            for (int j = 0; j < 32; j++) {
                if((nums[i] & binaryOne) != 0) {
                    binaryArray[j]++;
                }
                binaryOne <<= 1;
            }
        }
        // 对二进制数据中除以3然后还原
        // 还原 数据是相反的
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= binaryArray[31 - i] % m;
        }
        return res;
    }
}
