package 排序;

import java.util.Arrays;

/**
 * @author shizq18
 * @since 2023/4/20
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] array = new int[]{9,8,7,4,6,5};
        quickSortTest(array,0,5);
        System.out.println(Arrays.toString(array));
    }
    static void quickSortTest(int[] array,int low, int high){
        if (low < high) {
            int middle = searchMiddle(array, low, high);
            quickSortTest(array, low, middle - 1);
            quickSortTest(array, middle + 1, high);
        }
    }

    private static int searchMiddle(int[] array, int low, int high) {
        int middlePosition = low - 1;
        int referenceValue = array[high];
        for (int i = low; i < high; i++) {
            if (array[i] < referenceValue){
                //比参考点小的放到最左边
                middlePosition++;
                swap(array, middlePosition, i);
            }
        }
        //最后交换参考点的值与middlePosition位置
        swap(array, middlePosition + 1, high);
        return middlePosition + 1;
    }

    private static void swap(int[] array, int dest, int orign) {
        int temp = array[orign];
        array[orign] = array[dest];
        array[dest] = temp;
    }
}
