package 剑指offer100;

/**
 * @Author shizq18
 * @Date 2023/5/5
 * @Description
 */
public class 扑克牌中的顺子 {
    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{0,0,1,4,6}));
    }
    public static boolean isStraight(int[] nums) {
        int[] array = new int[14];
        for (int i = 0; i < nums.length; i++) {
            array[nums[i]]++;
        }

        int guideCount = array[0];
        int start = 0;
        int end = 13;
        for (int i = 1; i < 14; i++) {
            if (array[i] > 1) {
                return false;
            }
        }
        for (int i = 1; i < 14; i++) {
            if (array[i] == 1) {
                start = i;
                break;
            }
        }
        for (int i = 13; i > 0; i--) {
            if (array[i] == 1) {
                end = i;
                break;
            }
        }
        int lackNumCount = 0;
        for (int i = start + 1; i < end; i++) {
            if (array[i] == 0){
                lackNumCount++;
            }
        }
        if (lackNumCount <= guideCount){
            return true;
        }else {
            return false;
        }
    }
}
