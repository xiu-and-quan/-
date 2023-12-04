package 力扣热题100;

/**
 * @Author shizq18
 * @Date 2023/7/22
 * @Description
 */
public class 接雨水 {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    public static int trap(int[] height) {
        // 头顶几滴雨水 找他左右最高的坐标
        int len = height.length;
        int[] maxHeightLeft = new int[len];
        int[] maxHeightRight = new int[len];
        maxHeightLeft[0] = height[0];
        maxHeightRight[len-1] = height[len-1];
        for (int i = 1; i < len; i++) {
            if (height[i] < maxHeightLeft[i-1]) {
                maxHeightLeft[i] = maxHeightLeft[i-1];
            } else {
                maxHeightLeft[i] = height[i];
            }
        }
        for (int i = len-2; i >= 0; i--) {
            if (height[i] < maxHeightRight[i+1]) {
                maxHeightRight[i] = maxHeightRight[i+1];
            } else {
                maxHeightRight[i] = height[i];
            }
        }
        int res = 0;
        for (int i = 1; i < len-1; i++) {
            if (maxHeightLeft[i] > maxHeightRight[i]) {
                int num1 = maxHeightRight[i] - height[i];
                if (num1 > 0) {
                    res += num1;
                }
            } else {
                int num2 = maxHeightLeft[i] - height[i];
                if (num2 > 0) {
                    res += num2;
                }
            }
        }
        return res;
    }
}
