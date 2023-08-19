class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        if (s1.length () < s2.length ()) {
            return areSentencesSimilar(s2, s1);
        }
        String[] w1 = s1.split(" "), w2 = s2.split(" ");
        int i1 = 0, i2 = 0;
        int j1 = w1.length - 1, j2 = w2.length - 1;
        while(i2 <= j2){
            if(w1[i1].equals(w2[i2])){
                i1++;i2++;
            }else if(w1[j1].equals(w2[j2])){
                j1--;j2--;
            }else return false;
        }
        return true;
    }
}