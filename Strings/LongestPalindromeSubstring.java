// 2. Longest Palindromic Substring
// Given a string s, return the longest palindromic substring in s.
// Example 1:
// ```
// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
// ```
// Time Complexity = O(N ^ 2)
//  Space Complexity = O(1)
// ```



class Solution {
    public String longestPalindrome(String str) {
        int n = str.length();
		if (n < 1) {
			return "";
		}
		int start = 0, end = 0;
		for (int i = 0; i < n; i++) {
			// Longest odd length palindrome with center points as i.
			int len1 = expandAroundCenter(str, i, i);
			// Longest even length palindrome with center points as i and i + 1.
			int len2 = expandAroundCenter(str, i, i + 1);
			int len = Math.max(len1, len2);
			// Update the start and end.
			if (len > end - start + 1) {
				start = i - (len - 1) / 2;
				end = i + (len) / 2;
			}
		}
		return str.substring(start, end + 1);
    }
    private static int expandAroundCenter(String str, int left, int right) {
		int start = left, end = right;
		int n = str.length();
		// Expand the center.
		while (start >= 0 && end < n && str.charAt(start) == str.charAt(end)) {
			start--;
			end++;
		}
		return end - start - 1;
	}
}
```