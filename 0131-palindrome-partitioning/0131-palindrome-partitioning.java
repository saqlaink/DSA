class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        check(0,s,res,new ArrayList<>());
        return res;
    }
    public void check(int idx, String s,List<List<String>> res,List<String> ds){
        if(idx == s.length()){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                ds.add(s.substring(idx,i+1));
                check(i+1,s,res,ds);
                ds.remove(ds.size() - 1);
            }
        }
    }
    boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
// class Solution {
//     void fn(int index,String s,List<String> cur,List<List<String>> res){
//         if(index==s.length()){
//             res.add(new ArrayList<>(cur));
//             return;
//         }
//         for(int i=index;i<s.length();i++){
//             if(isPalindrome(s,index,i)){
//                 cur.add(s.substring(index,i+1));
//                 fn(i+1,s,cur,res);
//                 cur.remove(cur.size()-1);
//             }
//         }
//     }
//     boolean isPalindrome(String s,int start,int end){
//         while(start<=end){
//             if(s.charAt(start++)!=s.charAt(end--)){
//                 return false;
//             }
//         }
//         return true;
//     }
// }