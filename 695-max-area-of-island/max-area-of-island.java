class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    int area = count(i,j,0,grid);
                    maxArea = Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }
    public int count(int row,int col,int area,int[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >=grid[0].length || grid[row][col] == 0) return 0;
        grid[row][col] = 0;
        return 1 + count(row+1,col,area,grid) + count(row,col+1,area,grid) + count(row-1,col,area,grid) + count(row,col-1,area,grid);
    }
}