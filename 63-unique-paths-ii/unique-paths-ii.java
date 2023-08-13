class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] a: dp) Arrays.fill(a,-1);
        return count(m-1,n-1,m - 1,n - 1,obstacleGrid,dp);
    }
    public int count(int i,int j,int m,int n,int[][] grid,int[][] dp){
        if(i<0 || j<0 || grid[i][j] == 1) return 0;
        if(i==0 && j == 0) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = count(i-1,j,m,n,grid,dp) + count(i,j-1,m,n,grid,dp);
    }
}