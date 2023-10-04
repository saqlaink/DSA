class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        calc(0,cost,dp);
        return Math.min(dp[0],dp[1]);
    }
    public int calc(int idx,int[] cost,int[] dp){
        if(idx >= cost.length) return 0;
        if(dp[idx] > 0) return dp[idx];
        int cost1 = cost[idx] + calc(idx+1,cost,dp);
        int cost2 = cost[idx] + calc(idx+2,cost,dp);
        dp[idx] = Math.min(cost1,cost2);
        return dp[idx];
    }
}