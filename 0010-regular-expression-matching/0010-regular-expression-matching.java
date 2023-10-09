class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        return isMatch(0,0,s,p,dp);
    }
    public boolean isMatch(int i, int j,String s, String p,boolean[][] dp){
//         if(s.length() <= i && j >= p.length()) return true;
//         if(j>=p.length()) return false;
//         if(dp[i][j] != false) return true;
// //declaring a variable to check whether the first characters of s and p are a match or not
//         boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
//         //checking for second character
//         if((j+1) < p.length() && p.charAt(j+1) == '*'){
//             boolean notTake = isMatch(i,j+2,s,p,dp);
//             boolean take = match ? isMatch(i+1,j,s,p,dp) : false;
//             return dp[i][j] = take || notTake;
//         }
//         if(match) return dp[i][j] = isMatch(i+1,j+1,s,p,dp);
//         return dp[i][j] = false;
        if(s.length() <= i && j>=p.length()) return true;
        if(j>=p.length()) return false;
        if(dp[i][j] != false) return true;
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if((j+1) < p.length() && p.charAt(j+1) == '*'){
            boolean not = isMatch(i,j+2,s,p,dp);
            boolean take = match ? isMatch(i+1,j,s,p,dp) : false;
            return dp[i][j] = take || not;
        }
        if(match) return dp[i][j] = isMatch(i+1,j+1,s,p,dp);
        return dp[i][j] = false;
    }
}