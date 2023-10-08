class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totSum = 0;
        int n = nums.length;
        for(int a: nums) totSum += a;
        if(totSum < target) return 0;
        if((totSum - target) % 2 == 1) return 0;
        int s2 = (totSum - target) / 2;
        int[][] dp = new int[n][s2+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        return solve(n-1,s2,nums,dp);
    }
    public int solve(int idx,int tar,int[] arr,int[][] dp){
        if(idx == 0){
            if(tar == 0 && arr[0] == 0) return 2;
            if(tar == 0 || tar == arr[0]) return 1;
            return 0;
        }
        if(dp[idx][tar] != -1) return dp[idx][tar];
        int not = solve(idx-1,tar,arr,dp);
        int take = 0;
        if(arr[idx] <= tar){
            take = solve(idx - 1,tar - arr[idx],arr,dp);
        }
        return dp[idx][tar] = (take + not);
    }
}