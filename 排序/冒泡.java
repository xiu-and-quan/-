package 排序;

import java.util.Arrays;

public class 冒泡 {
    public static void main(String[] args) {
        int[] numbers = new int[]{5,4,3,2,1};
        BubbleSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
    public static void BubbleSort(int[] numbers){
        for (int i=0;i<numbers.length-1;i++){
            for (int j=0;j<numbers.length-1-i;j++){
                //比较前面的元素比后面元素大交换，同理也可以比较小
                if (numbers[j]>numbers[j+1]){
                    swap(numbers,j,j+1);
                }
            }
        }
    }

    private static void swap(int[] numbers, int j, int i) {
        int temp=numbers[j];
        numbers[j]=numbers[j+1];
        numbers[j+1]=temp;
    }
}
