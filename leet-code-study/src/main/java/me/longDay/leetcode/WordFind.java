package me.longDay.leetcode;

/**
 * @author 君
 * @version 1.0
 * @desc TODO
 * @since 2023-04-07
 */
public class WordFind {
    boolean [][]looked;
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(new WordFind().exist(board,word));
    }

    public boolean exist(char[][] board, String word) {
        if(word.length()==0)return true;
        int high=board.length;
        int wide=board[0].length;
        looked=new boolean[high][wide];
        int start=0,end=0;
        int www=word.length()-1;
        for (char[] chars : board) {
            for (int j = 0; j < wide; j++) {
                if (word.charAt(0) == chars[j]) {
                    start++;
                } else if (word.charAt(www) == chars[j]) {
                    end++;
                }
            }
        }
        if(start>end){
            word = new StringBuilder(word).reverse().toString();
        }
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < wide; j++) {
                if(word.charAt(0)==board[i][j]) {
                    looked[i][j] = true;
                    if (dfs(i, j, high, wide, word, board,1)) return true;
                    looked[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int high, int wide, String word, char[][] board,int length) {
        if(length==word.length())return true;
        if(i>0&&!looked[i-1][j]&&word.charAt(length)==board[i-1][j]){
            looked[i-1][j] = true;
            if (dfs(i-1, j, high, wide, word, board,length+1)) return true;
            looked[i-1][j] = false;
        }
        if(j>0&&!looked[i][j-1]&&word.charAt(length)==board[i][j-1]){
            looked[i][j-1] = true;
            if (dfs(i, j-1, high, wide, word, board,length+1)) return true;
            looked[i][j-1] = false;
        }
        if(i<high-1&&!looked[i+1][j]&&word.charAt(length)==board[i+1][j]){
            looked[i+1][j] = true;
            if (dfs(i+1, j, high, wide, word, board,length+1)) return true;
            looked[i+1][j] = false;
        }
        if(j<wide-1&&!looked[i][j+1]&&word.charAt(length)==board[i][j+1]){
            looked[i][j+1] = true;
            if (dfs(i, j+1, high, wide, word, board,length+1)) return true;
            looked[i][j+1] = false;
        }
        return false;
    }
}
