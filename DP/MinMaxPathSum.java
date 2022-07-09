static int getMaxUtil(int i, int j, int m, int[][] matrix,int[][] dp){
    // Base Conditions
    if(j<0 || j>=m) return (int)Math.pow(-10,9);
    if(i==0) return matrix[0][j];
    if(dp[i][j]!=-1) return dp[i][j];
    int up = matrix[i][j] + getMaxUtil(i-1,j,m,matrix,dp);
    int leftDiagonal = matrix[i][j] + getMaxUtil(i-1,j-1,m,matrix,dp);
    int rightDiagonal = matrix[i][j] + getMaxUtil(i-1,j+1,m,matrix,dp);
    return dp[i][j]= Math.max(up,Math.max(leftDiagonal,rightDiagonal));
}
static int getMaxPathSum(int[][] matrix){
    int n = matrix.length,m = matrix[0].length;
    int dp[][]= new int[n][m];
    for(int row[]: dp) Arrays.fill(row,-1);
    int maxi = Integer.MIN_VALUE;
    for(int j=0; j<m;j++){
        int ans = getMaxUtil(n-1,j,m,matrix,dp);
        maxi = Math.max(maxi,ans);
    }
    return maxi;
}