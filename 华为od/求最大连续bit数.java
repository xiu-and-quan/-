package 华为od;

import java.util.Map;
import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/13
 * @Description
 */
public class 求最大连续bit数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int value = in.nextInt();
        System.out.println(solve(value));
    }

    public static int solve(int value) {
        int[] binaryArray = new int[32];
        int compareValue = 1;
        for (int i = 0; i < 32; i++) {
            if ((value & compareValue) != 0) {
                binaryArray[i] = 1;
            }
            compareValue <<= 1;
        }
        // 双指针
        int res = 0;
        int left = 0, right = 0;
        while (right <= 32) {
            if (left < 32 && binaryArray[left] == 0) {
                left++;
                right=left;
            }else {
                right++;
                if (right >= 32 || binaryArray[right] == 0) {
                    res = Math.max(res,right-left);
                    left = right;
                }
            }
        }
        return res;
    }
}
