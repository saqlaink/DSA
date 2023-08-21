class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, total = 0, res = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            total += nums[i];
            while(total >= target){
                res = Math.min(i - l + 1,res);
                total -= nums[l];
                l++;
            }
        }
        if(res == Integer.MAX_VALUE) return 0;
        else return res;
    }
}