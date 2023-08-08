class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n <= 1) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int ans = minJumps(nums,0,dp);
        return ans;
    }
    public int minJumps(int[] nums, int idx,int[] dp){
        if(idx >= nums.length - 1) return 0;
        if(dp[idx] != -1) return dp[idx];

        int min = (int)(1e9);
        for(int i=nums[idx]; i>0; i--){
            int ans = 1 + minJumps(nums,idx+i,dp);
            min = Math.min(ans,min);
        }
        return dp[idx] = min;
    }
}