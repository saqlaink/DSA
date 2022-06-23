// 4. Longest Common Prefix
   
// Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string "".
// Example 1:
// ```
// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// ```
// - [ ] Binary Search: 
// Time Complexity: O(K. logN) where K is the sum of all the characters in all strings.
// Space Complexity: O(1)
// ```


class Solution {
    public static int findMinLen(String[] s,int n){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(s[i].length() < min){
                min = s[i].length();
            }
        }
        return min;
    }
    
    public String longestCommonPrefix(String[] s) {
        int n = s.length;
        int idx = findMinLen(s,n);
        String prefix = "";
        int low = 0, high = idx - 1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(allContainsPrefix(s,n,s[0],low,mid)){
                prefix = prefix + s[0].substring(low,mid+1);
                low = mid+1;
            }else high = mid - 1;
        }
        return prefix;
    }
    public static boolean allContainsPrefix(String[] s,int n,String str,int start,int end){
        for(int i=0;i<n;i++){
            String S_i = s[i];
            for(int j=start;j<=end;j++){
                if(S_i.charAt(j) != str.charAt(j)) return false;
            }
        }
        return true;
    }
}
```