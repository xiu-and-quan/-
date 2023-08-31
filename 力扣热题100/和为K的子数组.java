package 力扣热题100;

import jdk.internal.org.objectweb.asm.tree.IincInsnNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author shizq18
 * @Date 2023/8/1
 * @Description
 */
public class 和为K的子数组 {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));;
    }
    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> numToCount = new HashMap<>();
        int sumNum = 0;
        numToCount.put(sumNum, 1);
        for (int i = 0; i < nums.length; i++) {
            sumNum += nums[i];
            int remainNum = sumNum-k;
            res += numToCount.getOrDefault(remainNum, 0);
            numToCount.put(sumNum, numToCount.getOrDefault(sumNum,0)+1);
        }
        return res;
    }
}
