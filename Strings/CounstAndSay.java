// 10. Count and Say
// The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
// - countAndSay(1) = "1"
// - countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
// To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.


public String countAndSay(int n) {
        String s = "";
        switch(n){
            case 1: s = "1"; break;
            case 2: s = "11"; break;
            default: break;
        }
        if (n > 2) {
            s = "11";
            String ans;
            for (int i = 2; i < n; i++) {
               ans = "";
               int count = 0;
               char num = s.charAt(0);
               for (int j = 0; j < s.length(); ++j) {
                  char thisNum = s.charAt(j);
                  if (thisNum == num) {
                     count++;
                  }
                  else {
                     ans += count; ans += num;
                     num = thisNum;
                     count = 1;
                  }

                  if (j == s.length() - 1) {
                     ans += count; ans += num;
                  }
               }
               s = ans;
            }
         }
        return s;
    }
