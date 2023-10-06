class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][] dp = new int[n+1][amount+1];
        for(int[] a: dp) Arrays.fill(a,-1); 
        int ans = solve(n-1,amount,coins,dp);
        if(ans >= Integer.MAX_VALUE-1) {
            System.out.println(-1);
            return -1;
        }
        return ans;
    }
    public static int solve(int n,int s,int[] arr,int[][] dp){
        if(n == 0){
            if(s%arr[0] == 0) return s/arr[0];
            else return Integer.MAX_VALUE-1;
        }
        if(dp[n][s] != -1) return dp[n][s];
        int not = solve(n-1,s,arr,dp);
        int take = Integer.MAX_VALUE-1;
        if(arr[n] <= s) take = 1 + solve(n,s-arr[n],arr,dp);
        return dp[n][s] = Math.min(not,take);
    }
}