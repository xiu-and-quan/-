package 力扣热题100;

/**
 * @Author shizq18
 * @Date 2023/12/5
 * @Description
 */
public class 跳跃游戏II {
    /*输入: nums = [2,3,1,1,4]
      输出: 2*/
    public int solve(int[] nums) {
        int len = nums.length;
        int maxStep = 0;
        int end = 0;
        int step = 0;
        for (int i = 0; i < len; i++) {
            maxStep = Math.max(maxStep,nums[i]+i);
            if (i == end) {
                end = maxStep;
                step++;
            }
        }
        return step;
    }
}
