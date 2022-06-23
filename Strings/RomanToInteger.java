// 3. Roman to Integer
   
// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
// ```
// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
// ```
// For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
// - I can be placed before V (5) and X (10) to make 4 and 9. 
// - X can be placed before L (50) and C (100) to make 40 and 90. 
// - C can be placed before D (500) and M (1000) to make 400 and 900.
// Given a roman numeral, convert it to an integer.
// Time Complexity O(N), Where ‘N’ denotes the length of the string.We traverse the string once to find the integer value.
// Space ComplexityO(1).
// ```


import java.util.HashMap;
public class Solution {
    public static int romanToInt(String s) {
        int count = 0;
        // To store previous char value.
        int preInt = 0;
    // Hash map for finding interger value for roman numerals.
        HashMap<Character, Integer> conv = new HashMap<>();
        conv.put('I', 1);
        conv.put('V', 5);
        conv.put('X', 10);
        conv.put('L', 50);
        conv.put('C', 100);
        conv.put('D', 500);
        conv.put('M', 1000);
        // Loop from end to start of the string.
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            // Store current char integer value.
            int curInt = conv.get(ch);
            /*
                If current value is greater or equal to previous value then increment count i.e., II means 1+1
                else in case of IV, V = 5 and I = 1 here 1 < 5 then else part will execute and update count as 5 - 1 = 4.
            */
            if (curInt >= preInt) {
                count += curInt;
            } else {
                count -= curInt;
            }
            // Update 'preInt' value with current value for next iteration.
            preInt = curInt;
        }
        return count;
    }
}
```