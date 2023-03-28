package 剑指offer100;

public class 旋转数组中的最小数 {
    public int minArray(int[] numbers) {
        if(numbers.length == 1){
            return numbers[0];
        }
        int min = numbers[0];
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]>numbers[i+1]){
                min = numbers[i+1];
                break;
            }
        }
        return min;
    }
}
