class Solution {
    public int myAtoi(String str) {
        // str = str.trim();
        // if(str == null || str.length() == 0) return 0;
        // double result = 0;
        // boolean isNegative = false;
        // int startIdx  = 0;
        // if(str.charAt(0) == '+' || str.charAt(0) == '-') startIdx++;
        // if(str.charAt(0) == '-') isNegative = true;
        // for(int i=startIdx;i<str.length();i++){
        //     if(str.charAt(i) < '0' || str.charAt(i) > '9') break;
        //     int digitVal = (int)(str.charAt(i) - '0');
        //     result = result*10+digitVal;
        // }
        // if(isNegative) result = -result;
        
        // if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        // if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        // return (int)result;

        str = str.trim();
        if(str == null || str.length() == 0) return 0;
        double result = 0;
        boolean isNegative = false;
        int startIdx = 0;
        if(str.charAt(0) == '+' || str.charAt(0) == '-') startIdx++;
        if(str.charAt(0) == '-') isNegative = true;
        for(int i=startIdx;i<str.length();i++){
            if(str.charAt(i) < '0' || str.charAt(i) > '9') break;
            int digit = (int)(str.charAt(i) - '0');
            result = result*10 + digit;
        }
        if(isNegative) result = -result;
        return (int)result;
    }
}       