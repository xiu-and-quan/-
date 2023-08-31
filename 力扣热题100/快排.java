package 力扣热题100;

/**
 * @Author shizq18
 * @Date 2023/8/24
 * @Description
 */
public class 快排 {
    public static void main(String[] args) {
        quickSort(new int[]{5,2,4,3,1},0,4);
    }
    public static void quickSort(int[] list, int start, int end) {
        // 找一个标准点进行对比，一直递归 标准点定为最后一个数
        if (start < end){
            int middle = findMiddle(list,0,end);
            quickSort(list, start, middle-1);
            quickSort(list, middle+1, end);
        }
    }

    /**
     * 排序辅助
     */
    private static int findMiddle(int[] list, int start, int end) {
        // 以end为参考点
        int newStart = start-1;
        int referencePoint = list[end];
        for (int i = start; i < end; i++) {
            if (list[start] <= referencePoint) {
                newStart++;
                // 交换两个数
                swap(list, newStart, i);
            }
        }
        newStart++;
        swap(list, newStart, end);
        return newStart;
    }
    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
