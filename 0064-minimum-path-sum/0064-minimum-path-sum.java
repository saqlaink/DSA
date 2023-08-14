class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] a:dp) Arrays.fill(a,-1);
        return sum(m-1,n-1,grid,dp);
    }
    public int sum(int i,int j,int[][] grid,int[][] dp){
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j< 0) return (int)Math.pow(10,9);
        if(dp[i][j] != -1) return dp[i][j];
        int left = grid[i][j] + sum(i-1,j,grid,dp);
        int right = grid[i][j] + sum(i,j-1,grid,dp);
        return dp[i][j] = Math.min(left,right);
    }
}