package amazon;

public class MissingNumberInArray {
    int MissingNumber(int array[], int n) {
        // Your Code Here
        int[] incrementalArray = new int[n+1];
        for (int i = 0; i < array.length; i++) {
            incrementalArray[array[i]]++;
        }
        int missNymber=0;
        for (int i = 1; i < incrementalArray.length; i++) {
            if (incrementalArray[i] == 0){
                missNymber = i;
            }
        }
        return missNymber;
    }
}
