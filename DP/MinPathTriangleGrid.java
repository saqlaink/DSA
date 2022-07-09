static int mpsUtil(int i, int j, int[][] triangle,int n,int[][] dp) {
  if(dp[i][j]!=-1) return dp[i][j];
  if(i==n-1) return triangle[i][j];
  int down = triangle[i][j]+mpsUtil(i+1,j,triangle,n,dp);
  int diagonal = triangle[i][j]+mpsUtil(i+1,j+1,triangle,n,dp);
  return dp[i][j] = Math.min(down, diagonal);
}
static int minimumPathSum(int[][] triangle, int n){
    int dp[][]=new int[n][n];
    for(int row[]: dp)
    Arrays.fill(row,-1);
    return mpsUtil(0,0,triangle,n,dp);
}