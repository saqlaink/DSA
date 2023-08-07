class Solution {
    // List<String> res = new ArrayList<>();
    // public List<String> generateParenthesis(int n) {
    //     backtrack("",0,0,n);
    //     return res;
    // }
    // public void backtrack(String str,int open,int close,int n){
    //     if(str.length() == n*2) {
    //         res.add(str);
    //         return;
    //     }
    //     if(open < n) backtrack(str+"(",open+1,close,n);
    //     if(close < open) backtrack(str+")",open,close+1,n);
    // }
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        gen("",0,0,n);
        return res;
    }
    public void gen(String str,int open, int close,int n){
        if(str.length() == 2*n){
            res.add(str);
            return;
        }
        if(open < n) gen(str+"(",open+1,close,n);
        if(close<open) gen(str+")",open,close+1,n);
    }
}