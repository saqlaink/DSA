class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        return f(0,0,s,t,dp);
    }
    static int f(int i,int j,String s, String t,int[][] dp){
        if(dp[i][j] != -1) return dp[i][j];
        if(j>=t.length()) return 1;
        if(i>=s.length()) return 0;
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = f(i+1,j+1,s,t,dp) + f(i+1,j,s,t,dp);
        }
        return dp[i][j] = f(i+1,j,s,t,dp);
    }
}
// class Solution {
//     public int recursion(String s, String t, int sIdx, int tIdx, int[][] memo) {
//         if (memo[sIdx][tIdx] != -1) {
//             return memo[sIdx][tIdx];
//         }
//         if (tIdx >= t.length()) {
//             return 1;
//         }
//         if (sIdx >= s.length()) {
//             return 0;
//         }
//         if (t.charAt(tIdx) == s.charAt(sIdx)) {
//             memo[sIdx][tIdx] =
//                 recursion(s, t, sIdx + 1, tIdx + 1, memo) +
//                 recursion(s, t, sIdx + 1, tIdx, memo);
//             return memo[sIdx][tIdx];
//         }
//         memo[sIdx][tIdx] = recursion(s, t, sIdx + 1, tIdx, memo);
//         return memo[sIdx][tIdx];
//     }
// }
