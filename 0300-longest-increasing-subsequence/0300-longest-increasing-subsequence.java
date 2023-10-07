class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];
        for(int[] a: dp) Arrays.fill(a,-1);
        return solve(nums,0,-1,dp);
    }
    public int solve(int[] nums,int i,int prev,int[][] dp){
        if(i>=nums.length) return 0;
        if(dp[i][prev+1] != -1) return dp[i][prev+1];
        int not = solve(nums,i+1,prev,dp);
        int take = 0;
        if(prev == -1 || nums[i] > nums[prev]) take = 1 + solve(nums,i+1,i,dp);
        return dp[i][prev+1] = Math.max(take,not);
    }
}