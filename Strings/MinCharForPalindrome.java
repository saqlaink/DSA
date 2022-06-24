// 8. Minimum Characters required to make a String Palindromic
   
// Given an string A. The only operation allowed is to insert  characters in the beginning of the string.
// Find how many minimum characters are needed to be inserted to make the string a palindrome string.



/*
    Time complexity: O(N)
    Space complexity: O(N)
    Where N is length of the string.    
*/
public class Solution {
    public static int minCharsforPalindrome(String str) {
        String revStr = reverse(str);
        // Concatenate string with $ symbol and reverse string.
        String concat = str + "$" + revStr;
        // Get LPS array of this concatenated string
        int[] lps = calculateLPSArray(concat);
        return (str.length() - lps[lps.length - 1]);
    }
    // Function for calculating lps array
    public static int[] calculateLPSArray(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0;
        // As, lps[0] is always 0
        lps[0] = 0;
        // The loop calculates lps[i] for i = 1 to n-1.
        int i = 1;
        while (i < n) {
            // We get new prefix and new suffix, so increase length of  current lps by 1 and go to next iteration.
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // Don't increment i here
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    // There isn't any lps ends with pat[i], so set lps[i] = 0 and go to next iteration.
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    // Function for reverse a string
    public static String reverse(String s) {
        int n = s.length();
        StringBuffer sb = new StringBuffer(s);
        for (int i = n - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}