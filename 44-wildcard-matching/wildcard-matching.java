class Solution {
    static int wm(int i,int j,String s,String p,int[][] dp){
        if(i<0 && j<0) return 1;
        if(j<0 && i>=0) return 0;
        if(i<0 && j>=0){
            for(int k=0;k<=j;k++){
                if(p.charAt(k)!='*') {
                    return 0;
                }
            }
            return 1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            return dp[i][j] = wm(i-1,j-1,s,p,dp);
        }
        if(p.charAt(j)=='*'){
            return dp[i][j]= wm(i,j-1,s,p,dp)|wm(i-1,j,s,p,dp);
        }
        return dp[i][j] = 0;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return wm(n-1,m-1,s,p,dp)==1?true:false;
    }
}