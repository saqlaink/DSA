class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0) && search(board,word,i,j,0,vis)) return true;
            }
        }
        return false;
    }
    public boolean search(char[][] board, String word, int i, int j, int idx, boolean[][] vis){
        if(idx == word.length()) return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != word.charAt(idx) || vis[i][j]) return false;

        vis[i][j] = true;
        if(search(board,word,i+1,j,idx+1,vis) || search(board,word,i,j+1,idx+1,vis) || search(board,word,i-1,j,idx+1,vis) || search(board,word,i,j-1,idx+1,vis)) return true;
        vis[i][j] = false;
        return false;
    }
}