package 排序;

import java.util.Arrays;

/**
 * @author shizq18
 * @since 2023/4/23
 */
public class 归并 {
    public static void main(String[] args) {
        int[] numbers = new int[]{5,2,4,3,1};
        mergeSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    /**
     *  归并排序
     * @param array
     */
    public static int[] tempArray;
    public static int[] mergeSort(int[] array){
        int length = array.length;
        tempArray = new int[length];
        sort(array, 0, length-1);
        return array;
    }

    private static void sort(int[] array, int low, int high) {
        if (low >= high){
            return;
        }
        int middle = (low + high) / 2;
        //分
        sort(array, low , middle);
        sort(array, middle+1, high);
        //治
        merge(array, low, middle, high);
    }

    private static void merge(int[] array, int low, int middle, int high) {
        //replicate array
        for (int i = low; i <= high; i++) {
            tempArray[i] = array[i];
        }
        //merge
        int i = low, j = middle + 1;
        for (int k = low; k <= high; k++) {
            if (j > high){
                array[k] = tempArray[i++];
            } else if (i > middle) {
                array[k] = tempArray[j++];
            } else if (tempArray[i] > tempArray[j]) {
                array[k] = tempArray[j++];
            } else if (tempArray[i] < tempArray[j]) {
                array[k] = tempArray[i++];
            }
        }
    }
}
