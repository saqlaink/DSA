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