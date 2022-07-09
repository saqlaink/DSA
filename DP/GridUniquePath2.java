static int countWaysUtil(int m, int n, int[][] dp) {
 for(int i=0; i<m ;i++){
      for(int j=0; j<n; j++){
          //base condition
          if(i>0 && j>0 && maze[i][j]==-1) return 0;
//tabulation
          if(i>0 && j>0 && maze[i][j]==-1){
            dp[i][j]=0;
            continue;
          }
          int up=0;
          int left = 0;
          if(i>0) up = dp[i-1][j];
          if(j>0) left = dp[i][j-1];
          dp[i][j] = up+left;
      }
  }
  return dp[m-1][n-1];
}