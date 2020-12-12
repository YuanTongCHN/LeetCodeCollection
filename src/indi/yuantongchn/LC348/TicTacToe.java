package indi.yuantongchn.LC348;

//348. 判定井字棋胜负

class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int reverseDiagonal;
    private int size;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        size = n;
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        reverseDiagonal = 0;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int add;
        if(player == 1){
            add = 1;
        }else{
            add = -1;
        }
        rows[row] += add;
        cols[col] += add;
        if(row == col){
            diagonal += add;
        }
        if(row == size - 1 - col){
            reverseDiagonal += add;
        }
        if(Math.abs(rows[row]) == size || Math.abs(cols[col]) == size || Math.abs(diagonal) == size || Math.abs(reverseDiagonal) == size){
            return player;
        }
        return 0;
    }
}