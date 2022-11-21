package 差分数组;

public class 差分数组思想 {
    private int[] diff;
    private int[] res;
    /*输入一个初始数组，区间操作在这个数组上进行*/
    public 差分数组思想(int[] nums){
        int len = nums.length;
        diff = new int[len];
        diff[0] = nums[0];
        for (int i = 1; i < len; i++) {
            diff[i] = nums[i] - nums[i-1];
        }
    }

    public int[] increment(int i, int j, int value){

        diff[i] += value;
        if (j + 1 < diff.length) {
            diff[j + 1] -= value;
        }
        res = new int[diff.length];
        res[0] = diff[0];
        for (int k = 1; k < diff.length; k++) {
            res[k] = res[k - 1] + diff[k];
        }
        return res;
    }
}
