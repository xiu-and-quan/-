package amazon;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarysearch(new int[]{1,2,3,4,5},5,4));
    }
    static int binarysearch(int arr[], int n, int k) {
        // code here
        int left = 0,right = n-1;
        int mid = 0;
        while (left<=right){
            mid = (left + right)/2;
            if (k < arr[mid]){
                right = mid-1;
            }
            if (k > arr[mid]){
                left = mid+1;
            }
            if (k == arr[mid]){
                return mid+1;
            }
        }
        return -1;
    }
}
