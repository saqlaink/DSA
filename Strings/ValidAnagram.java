// 9. Valid Anagram
   
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int chars = 256;
        int[] hash = new int[chars];
        int i;
        for(i=0;i<s.length();i++){
            hash[s.charAt(i) - 'A']++;
            hash[t.charAt(i)]--;
        }
        for(i=0;i<chars;i++){
            if(hash[i] != 0) return false;
        }
        return true;
    }
}
