package 剑指offer100;

/**
 * @Author shizq18
 * @Date 2023/5/4
 * @Description
 */
public class 翻转单词顺序 {
    public static void main(String[] args) {
        //StringBuilder stringBuilder = new StringBuilder();
        String res = reverseWords(" ");
        System.out.println(res);
    }
    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
     * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
     * 则输出"student. a am I"。
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        if (s.length() == 0){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = s.length();
        // 双指针
        int left = size, right = size;
        while (left >= 0){
            if (left == 0 || s.charAt(left - 1) == ' '){
                if (left < size && s.charAt(left) == ' '){
                    right = left - 1;
                    left--;
                    continue;
                }
                for (int i = left; i < right; i++) {
                    stringBuilder.append(s.charAt(i));
                    if (i == right - 1){
                        stringBuilder.append(" ");
                    }
                }
                right = left - 1;
            }
            left--;
        }
        return stringBuilder.length() == 0 ? "" : String.valueOf(stringBuilder.deleteCharAt(stringBuilder.length() - 1));
    }
}
