class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totSum = 0;
        for(int a: nums) totSum+=a;
        if(totSum%2==1) return false;
        else{
            int k = totSum/2;
            int[][] dp = new int[n][k+1];
            for(int[] d: dp) Arrays.fill(d,-1);
            return subset(n-1,k,nums,dp);
        }
    }
    public boolean subset(int idx,int target,int[] nums,int[][] dp){
        if(target == 0) return true;
        if(idx == 0) return nums[0] == target;
        if(dp[idx][target] != -1) return dp[idx][target] == 0 ? false : true;
        boolean not = subset(idx-1,target,nums,dp);
        boolean taken = false;
        if(nums[idx] <= target){
            taken = subset(idx-1,target - nums[idx],nums,dp);
        }
        dp[idx][target] = not || taken ? 1 : 0;
        return not || taken;
    }
}