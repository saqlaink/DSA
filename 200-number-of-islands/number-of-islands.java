class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int row = grid.length, col = grid[0].length, count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }
    public static void dfs(int i,int j,char[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length) return;
        if(grid[i][j] == '1'){
            grid[i][j] = '2';
            dfs(i+1,j,grid);
            dfs(i-1,j,grid);
            dfs(i,j+1,grid);
            dfs(i,j-1,grid);
        }
    }
}
