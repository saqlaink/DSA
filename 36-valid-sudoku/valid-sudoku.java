class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] != '.' && !valid(board,i,j)) return false;
            }
        }
        return true;
    }
    boolean valid(char[][] board,int i,int j){
        for (int col = 0; col < 9; col++) {
            if (col != j && board[i][col] == board[i][j]) return false;
        }
        for (int row = 0; row < 9; row++) {
            if (row != i && board[row][j] == board[i][j]) return false;
        }
        int row = (i/3) * 3;                              // this is the row start o
        int col = (j/3) * 3;
        for(int r=row;r<row+3;r++){
            for(int c=col;c<col+3;c++){
                if(i!=r && c!=j && board[i][j] == board[r][c]) return false;
            }
        }
        return true;
    }
}