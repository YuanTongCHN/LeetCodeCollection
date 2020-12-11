package indi.yuantongchn.LC73;

//73. 矩阵置零

class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0){
            return;
        }
        boolean fisrtCol = false;
        boolean firstRow = false;
        //第一行第一列要特殊处理
        //判断第一行、第一列有没有0
        for (int j = 0; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0){
                firstRow = true;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0){
                fisrtCol = true;
                break;
            }
        }
        //判断除了第一列和第一行以外的0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //先把除了第一行和第一列的元素处理完
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        //处理第一行和第一列
        if(firstRow){
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(fisrtCol){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
