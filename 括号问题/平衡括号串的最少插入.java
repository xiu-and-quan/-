package 括号问题;

import java.util.Stack;

public class 平衡括号串的最少插入 {
    public int minInsertions(String s) {
        int need =0,res =0;
        for (int i = 0; i < s.length(); i++) {
            //对右括号的需求量
            if(s.charAt(i)==')'){
                need--;
                if(need == -1){
                    //需要一个左括号
                    res++;
                    //对右括号的需求量为1
                    need = 1;
                }
            }
            if(s.charAt(i)=='('){
                need += 2;
                if(need %2 == 1){
                    res++;
                    //对右括号需求-1
                    need--;
                }
            }
        }
        return res + need;
    }
}
