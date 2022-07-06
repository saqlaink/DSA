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



static int solve(int n, int[] arr){
   int prev = arr[0];
    int prev2 =0;
    for(int i=1; i<n; i++){
        int pick = arr[i];
        if(i>1) pick += prev2;
        int nonPick = 0 + prev;
        int cur_i = Math.max(pick, nonPick);
        prev2 = prev;
        prev= cur_i;
    }
    return prev;
}