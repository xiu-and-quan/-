package 排序.快排;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author shizq18
 * @Date 2023/6/6
 * @Description 快排，不仅能排序数字还是排序字符串
 */
public class Test {
    public static void main(String[] args) {
        /*Character[] array = new Character[]{'A','a','b','B'};
        Arrays.sort(array, (o1,o2)-> {
            return Character.toLowerCase(o1) - (Character.toLowerCase(o1));
        });
        System.out.println(Arrays.toString(array));

        List<Character> letters = new ArrayList<>();
        letters.add('A');
        letters.add('a');
        letters.add('c');
        letters.add('B');
        letters.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
            }
        });
        for (Character element:
             letters) {
            System.out.print(element + "  ");
        }*/
        int[] numbers = new int[]{9,8,7,6,5};
        quickSort(numbers, 0, 4);
        System.out.println(Arrays.toString(numbers));
    }

    public static void quickSort(int[] array, int left, int right){
        if (left < right){
            int middle = findMiddle(array, left, right);
            quickSort(array, left, middle-1);
            quickSort(array, middle+1, right);
        }
    }
    /*int[] numbers = new int[]{9,8,7,4,6,5};*/
    /*
    * 4,8,7,9,6,5
    * */
    private static int findMiddle(int[] array, int left, int right) {
        // 参照值
        int value = array[right];
        int middle = left-1;
        for (int i = left; i < right; i++) {
            if (array[i] <= value) {
                middle++;
                // 交换两个数
                swap(array, middle, i);
            }
        }
        middle++;
        swap(array, middle, right);
        return middle;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}

