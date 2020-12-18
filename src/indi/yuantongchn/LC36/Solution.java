package indi.yuantongchn.LC36;

//36. 有效的数独

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] sbox = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.'){
                    continue;
                }
                int index = (board[i][j] - '0') - 1;
                int boxIndex = (i / 3) * 3 + j / 3;
                if (row[i][index]) {
                    return false;
                } else {
                    row[i][index] = true;
                }
                if (col[j][index]) {
                    return false;
                } else {
                    col[j][index] = true;
                }
                if(sbox[boxIndex][index]){
                    return false;
                }else{
                    sbox[boxIndex][index] = true;
                }
            }
        }
        return true;
    }
}
