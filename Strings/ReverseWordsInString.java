// 1. Reverse Words in a String
   
// Given an input string s, reverse the order of the words.A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space. Return a string of the words in reverse order concatenated by a single space. Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
// ```
// Input: s = "  hello world  "
// Output: "world hello"
// ```
// Time Complexity  = O(N)
//  Space Complexity = O(N)
// ```


class Solution {
    public String reverseWords(String str) {
        if (str == null || str.length() == 0) {
			return str;
		}
		StringBuilder ans = new StringBuilder();
		// if the string is " " then return ""
		if (str.length() == 1 && str.charAt(0) == ' ') {
			return ans.toString();
		}
		int start = str.length() - 1;
		while (start >= 0) {
			// Skip multiple spaces
			if (str.charAt(start) == ' ') {
				start--;
			}
			else {
			// Add space between words
				if (ans.length() > 0) {
					ans.append(" ");
				}
				int j = start;
				// Loop for extracting word
				while (j >= 0 && str.charAt(j) != ' ') {
					j--;
				}
				// add current word to ans
				ans.append(str.substring(j + 1, start + 1));
				start = j;
			}
		}
		return ans.toString();
    }
}
```