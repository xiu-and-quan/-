package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/13
 * @Description
 */
public class 密码强度等级 {
    public static void main(String[] args) {
        /*一、密码长度:
        5 分: 小于等于4 个字符
        10 分: 5 到7 字符
        25 分: 大于等于8 个字符

        二、字母:
        0 分: 没有字母
        10 分: 密码里的字母全都是小（大）写字母
        20 分: 密码里的字母符合”大小写混合“

        三、数字:
        0 分: 没有数字
        10 分: 1 个数字
        20 分: 大于1 个数字

        四、符号:
        0 分: 没有符号
        10 分: 1 个符号
        25 分: 大于1 个符号

        五、奖励（只能选符合最多的那一种奖励）:
        2 分: 字母和数字
        3 分: 字母、数字和符号
        5 分: 大小写字母、数字和符号
        */
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String string = in.nextLine();
        int numCount = 0, smallCharacterCount = 0,
                bigCharacterCount = 0, symbolCount = 0;
        int size = string.length();
        int resScore = 0;
        if (size <= 4) {
            resScore = 5;
        } else if (size <= 7) {
            resScore = 10;
        } else {
            resScore = 25;
        }
        for (int i = 0; i < size; i++) {
            char element = string.charAt(i);
            if (element >= '0' && element <= '9') {
                numCount++;
            } else if (element >= 'a' && element <= 'z') {
                smallCharacterCount++;
            } else if (element >= 'A' && element <= 'Z') {
                bigCharacterCount++;
            } else {
                symbolCount++;
            }
        }
        if (smallCharacterCount != 0 && bigCharacterCount != 0) {
            resScore += 20;
        } else if (smallCharacterCount == 0 && bigCharacterCount == 0) {
            resScore += 0;
        }else {
            resScore += 10;
        }

        if (numCount == 1) {
            resScore += 10;
        } else if (numCount > 1) {
            resScore += 20;
        }

        if (symbolCount == 1) {
            resScore += 10;
        } else if (symbolCount > 1) {
            resScore += 25;
        }

        if (numCount != 0 && smallCharacterCount != 0 && bigCharacterCount != 0 && symbolCount != 0) {
            resScore += 5;
        }else if (numCount != 0 && symbolCount != 0 && (smallCharacterCount != 0 || bigCharacterCount != 0)) {
            resScore += 3;
        }else if (numCount != 0 && (smallCharacterCount != 0 || bigCharacterCount != 0)) {
            resScore += 2;
        }

        if (resScore >= 90) {
            System.out.println("VERY_SECURE");
        } else if (resScore >= 80) {
            System.out.println("SECURE");
        } else if (resScore >= 70) {
            System.out.println("VERY_STRONG");
        } else if (resScore >= 60) {
            System.out.println("STRONG");
        } else if(resScore >= 50) {
            System.out.println("AVERAGE");
        } else if (resScore >= 25) {
            System.out.println("WEAK");
        } else {
            System.out.println("VERY_WEAK");
        }
    }
}
