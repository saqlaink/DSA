static int longestPalindromeSubsequence(String s){
    String t = s;
    String ss=new StringBuilder(s).reverse().toString();
    return lcs(ss,t);
}
static int minInsertion(String s){
    int n = s.length();
    int k = longestPalindromeSubsequence(s); //previous question
    return n-k;
}