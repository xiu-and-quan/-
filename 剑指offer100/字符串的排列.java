package 剑指offer100;

import java.util.*;

public class 字符串的排列 {
    List<String> res = new LinkedList<>();
    public String[] permutation(String s) {
        char[] charArray = s.toCharArray();
        int size =charArray.length;
        boolean[] isPutted = new boolean[size];
        //标准回溯
        recall(charArray,isPutted,new StringBuilder());
        int index = 0;
        //去重
        Set<String> duplicateRemoval = new HashSet<>();
        for (String element:
                res) {
            duplicateRemoval.add(element);
        }
        String[] resStrings = new String[duplicateRemoval.size()];
        Iterator<String> iterator = duplicateRemoval.iterator();
        while (iterator.hasNext()){
            resStrings[index++] = iterator.next();
        }
        return resStrings;
    }

    private void recall(char[] charArray, boolean[] isPutted, StringBuilder stringBuilder) {
        //base case
        if (stringBuilder.length() == charArray.length){
            res.add(new String(stringBuilder));
        }
        for (int i = 0; i < charArray.length; i++) {
            if (isPutted[i]){
                continue;
            }
            isPutted[i] = true;
            stringBuilder.append(charArray[i]);

            recall(charArray,isPutted,stringBuilder);

            isPutted[i] = false;
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}