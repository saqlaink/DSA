class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0, j = tokens.length - 1;
        int points = 0, maxPoints = 0;
        while(i<=j){
            if(tokens[i] <= power){
                points++;
                power-=tokens[i++];
                maxPoints = Math.max(points,maxPoints);
            }else if(points > 0){
                points--;
                power+=tokens[j--];
            }else return maxPoints;
        }
        return maxPoints;
    }
}