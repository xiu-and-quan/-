package BFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 打开轮盘锁 {
    public static void main(String[] args) {
        String[] deadends = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
        int res = openLock(deadends,"8888");
        System.out.println(res);
    }
    public static int openLock(String[] deadends, String target) {
        //BFS
        HashSet<String> deadSet = new HashSet<>();
        HashSet<String> avoidRepeatElementSet = new HashSet<>();
        for(int i =0; i < deadends.length; i++){
            deadSet.add(deadends[i]);
        }
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        avoidRepeatElementSet.add("0000");
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentElement = queue.poll();
                if (target.equals(currentElement)){
                    return count;
                }
                if(deadSet.contains(currentElement)) {
                    continue;
                }
                for (int j = 0; j < 4; j++) {
                    String tempElement1 = leftAction(currentElement, j);
                    if (!avoidRepeatElementSet.contains(tempElement1)){
                        queue.add(tempElement1);
                        avoidRepeatElementSet.add(tempElement1);
                    }
                }
                for (int j = 0; j < 4; j++) {
                    String tempElement2 = rightAction(currentElement, j);
                    if (!avoidRepeatElementSet.contains(tempElement2)){
                        queue.add(tempElement2);
                        avoidRepeatElementSet.add(tempElement2);
                    }
                }
            }
            count++;
        }
        return -1;
    }
    public static String leftAction(String lock, int index){
        char[] lockArray = lock.toCharArray();
        if(lockArray[index] == '0'){
            lockArray[index] = '9';
        }else{
            lockArray[index] -= 1;
        }
        return new String(lockArray);
    }
    public static String rightAction(String lock, int index){
        char[] lockArray = lock.toCharArray();
        if(lockArray[index] == '9'){
            lockArray[index] = '0';
        }else{
            lockArray[index] += 1;
        }
        return new String(lockArray);
    }
}
