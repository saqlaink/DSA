// You’re given a string S of length N and a string P of length M. Your task is to find the number of occurrences of P in S in linear time.


public class Solution {
    public static int zAlgorithm(String text, String pattern) {
        String concat = pattern + "$" + text;
        int count = 0;
        int l = concat.length();
        int Z[] = new int[l]; //longest substring starting at the index which is also a prefix of string
        getZarr(concat, Z);
        // now looping through Z array for matching condition
        for(int i = 0; i < l; ++i){
  // if Z[i] (matched region) is equal to pattern length we got the pattern
            if(Z[i] == pattern.length()){
                count++;
            }
        }
        return count;
    }
        // Fills Z array for given string str[]
    private static void getZarr(String str, int[] Z) {
        int n = str.length();
        // [L,R] make a window which matches with prefix of s
        int L = 0, R = 0;
        for(int i = 1; i < n; ++i) {
            // if i>R nothing matches so we will calculate.
            // Z[i] using naive way.
            if(i > R){
                L = R = i;
                // R-L = 0 in starting, so it will start
                // checking from 0'th index. For example,
                // for "ababab" and i = 1, the value of R
                // remains 0 and Z[i] becomes 0. For string
                // "aaaaaa" and i = 1, Z[i] and R become 5
                while(R < n && str.charAt(R - L) == str.charAt(R))
                    R++;
                Z[i] = R - L;
                R--;
            } else{
                // k = i-L so k corresponds to number which
                // matches in [L,R] interval.
                int k = i - L;
                // if Z[k] is less than remaining interval
                // then Z[i] will be equal to Z[k].
                // For example, str = "ababab", i = 3, R = 5
                // and L = 2
                if(Z[k] < R - i + 1)
                    Z[i] = Z[k];
                // For example str = "aaaaaa" and i = 2, R is 5,
                // L is 0
                else{
                // else start from R and check manually
                    L = i;
                    while(R < n && str.charAt(R - L) == str.charAt(R))
                        R++;
                    Z[i] = R - L;
                    R--;
                }
            }
        }
    }
}