package 力扣热题100;

/**
 * @Author shizq18
 * @Date 2023/10/12
 * @Description
 */
public class 单词搜索 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board,"ABCB"));
    }
    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     */
    public static boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (tradver(board, i, j, word, 0, isVisited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 是否合法
     */
    private static boolean tradver(char[][] board, int i, int j, String word, int index, boolean[][] isVisited) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == word.charAt(index) && !isVisited[i][j]) {
            isVisited[i][j] = true;
            if(tradver(board,i+1,j,word,index+1, isVisited) || tradver(board,i-1,j,word,index+1, isVisited)
                    || tradver(board,i,j-1,word,index+1, isVisited) || tradver(board,i,j+1,word,index+1, isVisited)) {
                return true;
            }
            isVisited[i][j] = false;
        }
        return false;
    }
}
