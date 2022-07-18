static int lcs(String s1, String s2) {
    int n=s1.length();
    int m=s2.length();
    int dp[][]=new int[n+1][m+1];
// Base Case is covered as we have initialized the prev and cur to 0.
    for(int ind1=1;ind1<=n;ind1++){
        for(int ind2=1;ind2<=m;ind2++){
            if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
            else
                dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
        }
    }
    return dp[n][m];
}
static int longestPalindromeSubsequence(String s){
    String t = s;
    String ss=new StringBuilder(s).reverse().toString();
    return lcs(ss,t);
}