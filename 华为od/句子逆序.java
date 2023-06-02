package 华为od;

/**
 * @Author shizq18
 * @Date 2023/5/26
 * @Description
 */
public class 句子逆序 {
    public static void main(String[] args) {
        System.out.println(solve("i am xiu"));
    }
    /*将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
      所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符*/
    public static String solve(String string) {
        String[] stringArray = string.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int length = stringArray.length;
        for (int i = length-1; i >= 0; i--) {
            stringBuilder.append(stringArray[i]);
            if (i != 0){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
