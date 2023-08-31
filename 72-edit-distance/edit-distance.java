class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp=new int[n][m];
        for(int row[]: dp) Arrays.fill(row,-1);
        return count(n-1,m-1,word1,word2,dp);
    }
    public int count(int a,int b,String s1, String s2,int[][] dp){
        // if(a<0) return b+1;
        // if(b<0) return a+1;
        // if(dp[a][b] != -1) return dp[a][b];
        // if(s1.charAt(a) == s2.charAt(b)) return dp[a][b] = count(a-1,b-1,s1,s2,dp);
        // return dp[a][b] = 1 + Math.min(count(a-1,b,s1,s2,dp),Math.min(count(a,b-1,s1,s2,dp),count(a-1,b-1,s1,s2,dp)));
        if(a<0) return b+1;
        if(b<0) return a+1;
        if(dp[a][b] != -1) return dp[a][b];
        if(s1.charAt(a) == s2.charAt(b)) return dp[a][b] = count(a-1,b-1,s1,s2,dp);
        return dp[a][b] = 1 + Math.min(count(a-1,b,s1,s2,dp), Math.min(count(a,b-1,s1,s2,dp), count(a-1,b-1,s1,s2,dp)));
    }
}