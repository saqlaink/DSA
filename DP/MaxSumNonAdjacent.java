static int solveUtil(int ind, int[] arr, int[] dp){
    if(ind<0)  return 0;
    if(ind==0) return arr[ind];
    if(dp[ind]!=-1) return dp[ind];
    int pick= arr[ind]+ solveUtil(ind-2, arr,dp);
    int nonPick = 0 + solveUtil(ind-1, arr, dp);
    return dp[ind]=Math.max(pick, nonPick);
}
static int solve(int n,int[] arr){
    int dp[]=new int[n];
    Arrays.fill(dp,-1);
    return solveUtil(n-1, arr, dp);
}