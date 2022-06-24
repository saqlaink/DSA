// Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
// The algorithm for myAtoi(string s) is as follows:
// 1. Read in and ignore any leading whitespace.
// 2. Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
// 3. Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
// 4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
// 5. If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
// 6. Return the integer as the final result.
// Note:
// - Only the space character ' ' is considered a whitespace character.
// - Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
// Complexity Analysis:
// Since we end up iterating through the entire string in the worst case, the time complexity is T O(n), since we do not use any auxiliary space, S O(1).
// ```



class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str == null || str.length() == 0) return 0;
        double result = 0;
        boolean isNegative = false;
        int startIdx  = 0;
        if(str.charAt(0) == '+' || str.charAt(0) == '-') startIdx++;
        if(str.charAt(0) == '-') isNegative = true;
        for(int i=startIdx;i<str.length();i++){
            if(str.charAt(i) < '0' || str.charAt(i) > '9') break;
            int digitVal = (int)(str.charAt(i) - '0');
            result = result*10+digitVal;
        }
        if(isNegative) result = -result;
        
        if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        
        return (int)result;
    }
}
```