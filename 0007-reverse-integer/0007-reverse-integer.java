class Solution {
    public int reverse(int x) {
        // int rev = 0;
        // while(x!=0){
        //     int digit = x%10;
        //     if(rev>0 && rev > (Integer.MAX_VALUE - digit)/10) return 0;
        //     if(rev<0 && rev < (Integer.MIN_VALUE - digit)/10) return 0;
        //     rev = rev*10 + digit;
        //     x/=10;
        // }
        // return rev;

        int num = 0;
        while(x!=0){
            int digit = x%10;
            if(num > 0 && num > (Integer.MAX_VALUE - digit)/10) return 0;
            if(num < 0 && num < (Integer.MIN_VALUE - digit)/10) return 0;
            num = num*10 + digit;
            x=x/10;
        }
        return num;
    }
}
