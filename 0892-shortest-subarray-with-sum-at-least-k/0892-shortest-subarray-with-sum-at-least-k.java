class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;int shortest = Integer.MAX_VALUE;
        Deque<Pair> dq = new LinkedList<>();
        for(int i=0;i<n;i++){
            sum+=nums[i];
            while(!dq.isEmpty() && sum <= dq.peekLast().value) dq.removeLast();
            dq.add(new Pair(i,sum));
            if(sum >= k) shortest = Math.min(shortest,i+1);
            while(!dq.isEmpty() && sum - dq.peekFirst().value >= k){
                shortest = Math.min(shortest, i - dq.peekFirst().index);
                dq.removeFirst();
            }
        }
        return (shortest == Integer.MAX_VALUE) ? -1 : shortest;
    }
}
class Pair{
    int index;
    long value;
    Pair(int index, long value){
        this.index = index;
        this.value = value;
    }
}