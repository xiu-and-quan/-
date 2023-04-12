package 剑指offer100;

public class 正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        int row = s.length();
        int col = p.length();
        boolean[][] dp = new boolean[row+2][col+2];

        //base case
        dp[1][1] = true;
        for (int i = 1; i < col; i++) {
            if (p.charAt(i) == '*'){
                dp[1][i+2] = dp[1][i];
            }
        }

        //遍历状态
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (p.charAt(j) == '*'){
                    if (j-1>=0){
                        if (s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                            //表示无限次
                            dp[i+2][j+2] = dp[i+1][j+2] || dp[i+2][j];
                        }else {
                            //表示0次
                            dp[i+2][j+2] = dp[i+2][j];
                        }
                    }
                }else {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                        dp[i+2][j+2] = dp[i+1][j+1];
                    }
                }
            }
        }
        return dp[row+1][col+1];
    }
}
