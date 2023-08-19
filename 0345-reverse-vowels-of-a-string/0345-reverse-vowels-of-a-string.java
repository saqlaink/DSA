class Solution {
    public String reverseVowels(String s) {
        int l = 0, r = s.length() - 1;
        char[] ch = s.toCharArray();
        while(l<r){
            if(!isVowel(ch[l])) l++;
            else if(!isVowel(ch[r])) r--;
            else{
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;
                l++;r--;
            }
        }
        return new String(ch);
    }
    public boolean isVowel(char temp) {
        if(temp == 'a'|| temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u' || temp == 'A'|| temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U') return true;
        return false;
    }
}