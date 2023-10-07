class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] a: dp) Arrays.fill(a,-1);
        return count(m-1,n-1,m,n,dp);
    }
    public int count(int i,int j,int m,int n,int[][] dp){
        // if(i == 0 && j == 0) return 1;
        // if(i<0 || i>=m || j<0 || j>=n) return 0;
        // if(dp[i][j] != -1) return dp[i][j];
        // return dp[i][j] = count(i-1,j,m,n,dp) + count(i,j-1,m,n,dp);
        if(i == 0 && j == 0) return 1;
        if(i<0 || i>=m || j<0 || j>=n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = count(i-1,j,m,n,dp) + count(i,j-1,m,n,dp);
    }
}