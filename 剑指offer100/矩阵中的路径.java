package 剑指offer100;

import java.util.LinkedList;
import java.util.Queue;

public class 矩阵中的路径 {
    public static void main(String[] args) {
        char[][] board = new char[][]{  {'a','b','c','e'},
                                        {'s','f','c','s'},
                                        {'a','d','e','e'}};
        //char[][] board = new char[][]{{'a'}};
        System.out.println(exist(board,"abcb"));
    }
    public static boolean exist(char[][] board, String word) {
        //回溯
        boolean isExistRes = false;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] isPuted = new boolean[row][col];
                    isPuted[i][j] = true;
                    isExistRes = isExistRes || isExist(board, word, 1, isPuted,i,j,new StringBuilder().append(board[i][j]));
                }
            }
        }
        return isExistRes;
    }

    private static boolean isExist(char[][] board, String word, int index, boolean[][] isPuted,int cuurrentRow,int currentCol,StringBuilder stringBuilder) {
        //结束条件
        if (word.equals(stringBuilder.toString())){
            return true;
        }
        //做选择
        //上下左右
        if (cuurrentRow-1>=0){
            if (board[cuurrentRow-1][currentCol] == word.charAt(index) && isPuted[cuurrentRow-1][currentCol] == false){
                isPuted[cuurrentRow-1][currentCol] = true;
                stringBuilder.append(board[cuurrentRow-1][currentCol]);
                if(isExist(board,word,index+1,isPuted,cuurrentRow-1,currentCol,stringBuilder)){
                    return true;
                }
                //撤销选择
                isPuted[cuurrentRow-1][currentCol] = false;
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }

        }
        if (cuurrentRow+1<board.length){
            if (board[cuurrentRow+1][currentCol] == word.charAt(index) && isPuted[cuurrentRow+1][currentCol] == false){
                isPuted[cuurrentRow+1][currentCol] = true;
                stringBuilder.append(board[cuurrentRow+1][currentCol]);
                if(isExist(board,word,index+1,isPuted,cuurrentRow+1,currentCol,stringBuilder)){
                    return true;
                }
                //撤销选择
                isPuted[cuurrentRow+1][currentCol] = false;
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }

        }
        if (currentCol-1>=0){
            if (board[cuurrentRow][currentCol-1] == word.charAt(index) && isPuted[cuurrentRow][currentCol-1] == false){
                isPuted[cuurrentRow][currentCol-1] = true;
                stringBuilder.append(board[cuurrentRow][currentCol-1]);
                if(isExist(board,word,index+1,isPuted,cuurrentRow,currentCol-1,stringBuilder)){
                    return true;
                }
                //撤销选择
                isPuted[cuurrentRow][currentCol-1] = false;
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        }
        if (currentCol+1<board[0].length){
            if (board[cuurrentRow][currentCol+1] == word.charAt(index) && isPuted[cuurrentRow][currentCol+1] == false){
                isPuted[cuurrentRow][currentCol+1] = true;
                stringBuilder.append(board[cuurrentRow][currentCol+1]);
                if(isExist(board,word,index+1,isPuted,cuurrentRow,currentCol+1,stringBuilder)){
                    return true;
                }
                //撤销选择
                isPuted[cuurrentRow][currentCol+1] = false;
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }

        }
        return false;
    }
    /*public static boolean exist(char[][] board, String word) {
        boolean isExistRes = false;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)){
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    boolean[][] isPuted = new boolean[row][col];
                    isPuted[i][j] = true;
                    isExistRes = isExistRes || isExist(board,word,1,queue,isPuted);
                }
            }
        }
        return isExistRes;
    }

    private static boolean isExist(char[][] board, String word, int index, Queue<int[]> queue,boolean[][] isPuted) {
        int row = board.length;
        int col = board[0].length;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentElement = queue.poll();
                int currentRow = currentElement[0];
                int currentCol = currentElement[1];
                if (index == word.length()){
                    return true;
                }
                //上下左右往里面放
                //up
                if (currentRow - 1 >=0
                    && isPuted[currentRow-1][currentCol] == false
                    && board[currentRow-1][currentCol] == word.charAt(index)){
                        if (index == word.length()-1){
                            return true;
                        }
                        queue.add(new int[]{currentRow-1,currentCol});
                        isPuted[currentRow-1][currentCol] = true;
                    }
                //down
                if (currentRow + 1 < row
                    && isPuted[currentRow+1][currentCol] == false
                    && board[currentRow+1][currentCol] == word.charAt(index)){
                        if (index == word.length()-1){
                            return true;
                        }
                        queue.add(new int[]{currentRow+1,currentCol});
                        isPuted[currentRow+1][currentCol] = true;
                }

                //left
                if (currentCol - 1 >= 0
                    && isPuted[currentRow][currentCol-1] == false
                    && board[currentRow][currentCol-1] == word.charAt(index)){
                    if (index == word.length()-1){
                        return true;
                    }
                    queue.add(new int[]{currentRow,currentCol-1});
                    isPuted[currentRow][currentCol-1] = true;
                }
                //right
                if (currentCol + 1 < col
                        && isPuted[currentRow][currentCol+1] == false
                        && board[currentRow][currentCol+1] == word.charAt(index)){
                    if (index == word.length()-1){
                        return true;
                    }
                    queue.add(new int[]{currentRow,currentCol+1});
                    isPuted[currentRow][currentCol+1] = true;
                }
            }
            index++;
        }
        return false;
    }*/

}
