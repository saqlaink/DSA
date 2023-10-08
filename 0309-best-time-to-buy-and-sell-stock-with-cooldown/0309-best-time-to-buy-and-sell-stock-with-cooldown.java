class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] a: dp) Arrays.fill(a,-1);
        return solve(0,0,n,prices,dp);
    }
    public int solve(int idx, int buy, int n, int[] arr,int[][] dp){
        if(idx>=n) return 0;
        if(dp[idx][buy] != -1) return dp[idx][buy];
        int profit = 0;
        if(buy == 0){
            profit = Math.max(0 + solve(idx+1,0,n,arr,dp), -arr[idx] + solve(idx+1,1,n,arr,dp));
        }
        if(buy == 1){
            profit = Math.max(0 + solve(idx+1,1,n,arr,dp), arr[idx] + solve(idx+2,0,n,arr,dp));
        }
        dp[idx][buy] = profit;
        return profit;
    }
}
// class TUF {
//     static int getAns(int[] Arr, int ind, int buy, int n, int[][] dp) {
//         int profit = 0;
//         if (buy == 0) { // We can buy the stock
//             profit = Math.max(0 + getAns(Arr, ind + 1, 0, n, dp), -Arr[ind] + getAns(Arr, ind + 1, 1, n, dp));
//         }
//         if (buy == 1) { // We can sell the stock
//             profit = Math.max(0 + getAns(Arr, ind + 1, 1, n, dp),Arr[ind] + getAns(Arr, ind + 2, 0, n, dp));
//         }
//         dp[ind][buy] = profit;
//         return profit;
//     }
//     static int stockProfit(int[] Arr) {
//         int n = Arr.length;
//         int[][] dp = new int[n][2];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         int ans = getAns(Arr, 0, 0, n, dp);
//         return ans;
//     }
// }

