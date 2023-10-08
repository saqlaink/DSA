class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int[] d: dp) Arrays.fill(d,-1);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j] == -1) dfs(i,j,m,n,-1,matrix,dp);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int[] a: dp){
            for(int i: a) max = Math.max(i,max);
        }
        return max;
    }
    public int dfs(int i,int j,int m,int n,int par,int[][] mat,int[][] dp){
        if(i>=m || j>=n || i<0 || j<0 || mat[i][j] <=par) return 0;
        par = mat[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int left = dfs(i,j-1,m,n,par,mat,dp);
        int right = dfs(i,j+1,m,n,par,mat,dp);
        int bottom = dfs(i+1,j,m,n,par,mat,dp);
        int top = dfs(i-1,j,m,n,par,mat,dp);
        dp[i][j] = 1 + Math.max(Math.max(left,right), Math.max(top,bottom));
        return dp[i][j];
    }
}
