package amazon;

import java.util.Arrays;

public class SortAndArrayOf0s1sAnd2s {
    public static void main(String[] args) {
        sort012(new int[]{0,1,0},3);
    }
    public static void sort012(int a[], int n)
    {
        int count0 = 0,count1 = 0,count2 = 0;
        // code here
        for (int i = 0; i < n; i++) {
            if (a[i] == 0){
                count0++;
            }else if (a[i] == 1){
                count1++;
            }else if(i < count2){
                count2++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i < count0){
                a[i] = 0;
            }else if(i<count1+count0){
                a[i] = 1;
            }else {
                a[i] = 2;
            }
        }
    }

    private static void swap(int left, int move, int[] a) {
        int temp = a[move];
        a[move] = a[left];
        a[left] = temp;
    }
}
