public static int minSubsetSumDifference(int[] arr, int n) {
    int totSum = 0;
    for(int a: arr) totSum+=a;
    int k = totSum;
    boolean[][] dp = new boolean[n][k+1];
    for(int i=0;i<n;i++) dp[i][0] = true;
    if(arr[0] <= k) dp[0][arr[0]] = true;
    for(int ind=1;ind<n;ind++){
        for(int target=1;target<=k;target++){
            boolean notTake = dp[ind-1][target];
            boolean take = false;
            if(arr[ind] <= target) take = dp[ind-1][target-arr[ind]];
            dp[ind][target] = take || notTake;
        }
    }
    int mini = Integer.MAX_VALUE;
    for(int s1=0;s1<=totSum/2;s1++){
        if(dp[n-1][s1] == true){
            mini = Math.min(mini, Math.abs((totSum - s1)-s1));
        }
    }
    return mini;
}