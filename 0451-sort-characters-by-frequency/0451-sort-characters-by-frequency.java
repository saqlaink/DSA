class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        StringBuilder ans = new StringBuilder();
        pq.addAll(map.keySet());
        while(!pq.isEmpty()){
            char curr = pq.remove();
            int l = map.get(curr);
            while(l-- > 0){
                ans.append(curr);
            }
        }
        return ans.toString();
    }
}