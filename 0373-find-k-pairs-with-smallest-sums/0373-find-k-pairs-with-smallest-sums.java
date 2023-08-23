class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k){
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int x: nums1){
            pq.add(new int[]{x+nums2[0], 0}); //sum & idx of num2
        }
        while(k>0 && !pq.isEmpty()){
            int[] pair = pq.poll();
            int sum = pair[0];
            int idx = pair[1];
            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(sum - nums2[idx]);
            currentPair.add(nums2[idx]);
            res.add(currentPair);
            if(idx+1 < nums2.length){
                pq.add(new int[]{sum - nums2[idx] + nums2[idx+1], idx+1});
            }
            k--;
        }
        return res;
    }
}