class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        
        if (s1.length () < s2.length ()) {
            return areSentencesSimilar(s2, s1);
        }
        String[] w1 = s1.split(" "), w2 = s2.split(" ");
        int n1 = w1.length, n2 = w2.length;
        int i = 0, j = n1 - 1, k = n2 - 1;
        while(i < n2 && w1[i].equals(w2[i])) i++;
        while(k >= 0 && w1[j].equals(w2[k])){
            j--;k--;
        }
        return i > k;
    }
}