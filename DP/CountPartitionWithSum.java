public class Solution {
    public static int findWays(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar+1];
        for(int[] a: dp) Arrays.fill(a,-1);
        return f(n-1,tar,num,dp);
    }
    static int f(int idx,int tar,int[] num,int[][] dp){
        if(tar == 0) return 1;
        if(idx == 0){
            if(num[idx] == tar) return 1;
            else return 0;
        }

        if(dp[idx][tar] != -1) return dp[idx][tar];
        int notTake = f(idx-1,tar,num,dp);
        int take = 0;
        if(num[idx] <= tar) take = f(idx-1,tar-num[idx],num,dp);
        return dp[idx][tar] = take+notTake;
    }
}


public static int findWays(int num[], int tar) {
    int n = num.length;
    int[][] dp = new int[n][tar+1];
    for(int i=0;i<n;i++) dp[i][0] = 1;
    if(num[0] <= tar) dp[0][num[0]] = 1;

//for subsets with 0
//if(num[0] == 0) dp[0][0] =2;  // 2 cases -pick and not pick
//else dp[0][0] = 1;  // 1 case - not pick
//if(num[0]!=0 && num[0]<=tar) dp[0][num[0]] = 1;  // 1 case -pick

    for(int idx=1;idx<n;idx++){
        for(int sum=0;sum<=tar;sum++){
            int notTake = dp[idx-1][sum];
            int take = 0;
            if(num[idx] <= sum) take = dp[idx-1][sum-num[idx]];
            dp[idx][sum] = take+notTake;
        }
    }
    return dp[n-1][tar];
}