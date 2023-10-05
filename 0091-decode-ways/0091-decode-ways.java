class Solution {
    public int numDecodings(String s) {
        return calc(s,0,new int[s.length()]);
    }
    public int calc(String s, int i,int[] dp){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != 0) return dp[i];
        int count = 0;
        count += calc(s,i+1,dp);
        if(i<s.length()-1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7')){
            count+=calc(s,i+2,dp);
        }
        dp[i] = count;
        return dp[i];
    }
}
