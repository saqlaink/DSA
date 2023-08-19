class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<n/2;i++){
            int sum = nums[i] + nums[n-1-i];
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}