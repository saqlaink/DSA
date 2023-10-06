class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;
        for(int i=n-1;i>=0;i--){
            for(String w: wordDict){
                if((i+w.length()) <= s.length() && s.startsWith(w,i)){
                    dp[i] = dp[i+w.length()];
                }
                if(dp[i]) break;
            }
        }
        return dp[0];
    }
}