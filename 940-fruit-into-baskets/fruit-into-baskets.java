class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int i = 0, j = 0, ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(i<n){
            map.put(fruits[i], map.getOrDefault(fruits[i],0) + 1);
            if(map.size() > 2){
                while(map.size() > 2){
                    map.put(fruits[j], map.get(fruits[j]) - 1);
                    if(map.get(fruits[j]) == 0) map.remove(fruits[j]);
                    j++;
                }
            }
            ans = Math.max(ans, i - j + 1);
            i++;
        }
        return ans;
    }
}