package 力扣热题100;


import static java.util.Arrays.sort;

/**
 * @Author shizq18
 * @Date 2024/1/11
 * @Description
 */
public class 颜色分类 {
    public static void main(String[] args) {
        int[] nums = new int[]{9,8,7,6,5};
        sortColors(nums);
        System.out.println(nums);
    }
    public static void sortColors(int[] nums) {
        // 快排
        quickSort(nums, 0, nums.length-1);
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int middle = finMiddle(nums, start, end);
            quickSort(nums, start, middle-1);
            quickSort(nums, middle+1, end);
        }
    }

    private static int finMiddle(int[] nums, int start, int end) {
        int point = nums[end];
        int splid = start-1;
        for (int i = start; i < end; i++) {
            if (nums[i] <= point) {
                // 交换
                splid++;
                swap(nums, splid, i);
            }
        }
        // 交换
        splid++;
        swap(nums, splid, end);
        return splid;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static int[] tempArray;
    public static int[] mergeSort(int[] array){
        int length = array.length;
        tempArray = new int[length];
        sortHelp(array, 0, length-1);
        return array;
    }

    private static void sortHelp(int[] array, int start, int end) {
        // 分治
        if (start < end) {
            int middle = (start + end) / 2;
            sortHelp(array, start, middle);
            sortHelp(array, middle+1, end);
            merge(array, start, middle, end);
        }
    }

    private static void merge(int[] array, int start, int middle, int end) {
        for (int i = start; i <= end; i++) {
            tempArray[i] = array[i];
        }
        int i = start, j = middle+1;
        for (int k = start; k < end; k++) {
            if (j > end) {
                array[k] = tempArray[j];
                j++;
            } else if (i > middle) {
                array[k] = tempArray[i];
                i++;
            }
            else if (tempArray[i] < tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else if(tempArray[i] > tempArray[j]){
                array[k] = tempArray[j];
                j++;
            }
        }
    }
}
