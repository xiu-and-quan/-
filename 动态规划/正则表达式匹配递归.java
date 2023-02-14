package 动态规划;

public class 正则表达式匹配递归 {
    public static void main(String[] args) {
        System.out.println(isMatch("mississippi", "mis*is*ip*."));
    }

    public static boolean isMatch(String s, String p) {
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        return helperFunction(sArray, s.length() - 1, pArray, p.length() - 1);
    }

    private static boolean helperFunction(char[] sArray, int length1, char[] pArray, int length2) {
        //base case
        if (length2 < 0 && length1 >= 0) {
            return false;
        }
        if (length1 < 0 && length2 >= 0) {
            for(int i = length2; i >=0; i -= 2){
                    if (pArray[i] == '*'){
                        continue;
                    }else {
                        return false;
                    }
            }
            return true;
        }
        if (pArray[length2] == '*') {
            if (length2 - 1 >= 0) {
                if (sArray[length1] == pArray[length2 - 1] || pArray[length2 - 1] == '.') {
                    return helperFunction(sArray, length1, pArray, length2 - 2) || helperFunction(sArray, length1 - 1, pArray, length2);
                } else {
                    return helperFunction(sArray, length1, pArray, length2 - 2);
                }
            }
            } else {
                if (sArray[length1] == pArray[length2] || pArray[length2] == '.') {
                    return helperFunction(sArray, length1 - 1, pArray, length2 - 1);
                } else {
                    return false;
                }
            }
        return false;
    }
}
