class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            if(i == 0 || nums[i] != nums[i-1]){
                int low = i+1, hi = n-1;
                int sum = 0 - nums[i];
                while(low < hi){
                    if(nums[low] + nums[hi] == sum){
                        res.add(Arrays.asList(nums[i],nums[low],nums[hi]));
                        while(low < hi && (nums[low] == nums[low+1])) low++;
                        while(low < hi && (nums[hi] == nums[hi-1])) hi--;
                        low++;hi--;
                    }else if(nums[low] + nums[hi] > sum) hi--;
                    else low++;
                }
            }
        }
        return res;
    }
}