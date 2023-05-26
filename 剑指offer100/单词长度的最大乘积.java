package 剑指offer100;

/**
 * @Author shizq18
 * @Date 2023/5/16
 * @Description
 */
public class 单词长度的最大乘积 {
    public int maxProduct(String[] words) {
        // 位掩码
        int length = words.length;
        int[] binaryArray = new int[length];
        for (int i = 0; i < length; i++) {
            String currentWord = words[i];
            int wordLength = currentWord.length();
            for (int j = 0; j < wordLength; j++) {
                binaryArray[i] |= 1 << (currentWord.charAt(j) - 'a');
            }
        }
        int maxResLength = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((binaryArray[i] & binaryArray[j]) == 0) {
                    maxResLength = Math.max(words[i].length() * words[j].length(), maxResLength);
                }
            }
        }
        return maxResLength;
    }
}
