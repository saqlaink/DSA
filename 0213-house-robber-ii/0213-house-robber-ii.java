class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int ans1 = calc(0,n-1,nums);
        int ans2 = calc(1,n,nums);
        return Math.max(ans1,ans2);
    }
    public int calc(int start,int n,int[] nums){
        int prev2 = 0, prev = nums[start];
        for(int i=start+1;i<n;i++){
            int pick = prev2 + nums[i];
            int not = prev;
            int curr = Math.max(pick,not);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}