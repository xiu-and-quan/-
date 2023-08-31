package 力扣热题100;

/**
 * @Author shizq18
 * @Date 2023/8/24
 * @Description
 */
public class mergeSortPractice {

    public static int[] tempArray;
    public static void mergeSort(int[] list) {
        // 找中点再合并，一步一步合并
        int size = list.length;
        tempArray = new int[size];
        mergeSortHelp(list,0,size-1);
    }

    private static void mergeSortHelp(int[] list, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start+end)/2;
        // 分
        mergeSortHelp(list,start,middle);
        mergeSortHelp(list,middle+1,end);
        // 治
        mergeArray(list,start,middle,end);
    }

    private static void mergeArray(int[] list, int start, int middle, int end) {
        //replicate array
        for (int i = start; i <= end; i++) {
            tempArray[i] = list[i];
        }
        //merge
        int i = start, j = middle + 1;
        for (int k = start; k <= end; k++) {
            if (j > end){
                list[k] = tempArray[i++];
            } else if (i > middle) {
                list[k] = tempArray[j++];
            } else if (tempArray[i] > tempArray[j]) {
                list[k] = tempArray[j++];
            } else if (tempArray[i] < tempArray[j]) {
                list[k] = tempArray[i++];
            }
        }
    }
}
