class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return calc(n,dp);
    }
    public int calc(int n,int[] dp){
        if(n <= 1) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = calc(n-1,dp) + calc(n-2,dp);
    }
}