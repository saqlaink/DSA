class Solution {
    public int maxCoins(int[] nums) {
        var dp = new int[nums.length][nums.length];
        return solve(0,nums.length - 1, nums,dp);
    }
    public int solve(int left,int right,int[] nums,int[][] dp){
        if(left > right) return 0;
        if(dp[left][right] != 0) return dp[left][right];
        for(int i=left;i<=right;i++){
            int coins = nums[i]; //if popped last
            if(left - 1 >= 0) coins *= nums[left - 1];
            if(right + 1 < nums.length) coins *= nums[right + 1];
            coins += solve(left,i-1,nums,dp) + solve(i+1,right,nums,dp);
            dp[left][right] = Math.max(dp[left][right], coins);
        }
        return dp[left][right];
    }
}
// class Solution {
//     private int burst(int[] nums, int left, int right, int[][] dp) {
//         for (int i = left; i <= right; i++) {
//             int coins = nums[i];
//             if (left - 1 >= 0) {
//                 coins *= nums[left - 1];
//             }
//             if (right + 1 < nums.length) {
//                 coins *= nums[right + 1];
//             }
//             coins += burst(nums, left, i - 1, dp) + burst(nums, i + 1, right, dp);
//             dp[left][right] = Math.max(dp[left][right], coins);
//         }
//         return dp[left][right];
//     }
// }
