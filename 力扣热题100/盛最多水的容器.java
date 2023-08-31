package 力扣热题100;

import java.util.Arrays;

/**
 * @Author shizq18
 * @Date 2023/7/20
 * @Description
 */
public class 盛最多水的容器 {
    public static void main(String[] args) {
        int resArea = maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(resArea);
    }
    public static int maxArea(int[] height) {
        /*输入：[1,8,6,2,5,4,8,3,7]
          输出：49 */
        int i = 0, j = height.length - 1, res = 0;
        while(i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
