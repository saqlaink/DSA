class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Arrays.sort(nums);
        // int result = nums[0] + nums[1] + nums[nums.length - 1];
        // for(int i=0;i<nums.length - 2;i++){
        //     int low = i+1, high = nums.length -1;
        //     while(low < high){
        //         int sum = nums[i] + nums[low] + nums[high];
        //         if(sum > target) high--;
        //         else low++;
        //         if(Math.abs(sum - target) < Math.abs(result - target)){
        //             result = sum;
        //         }
        //     }
        // }
        // return result;
        Arrays.sort(nums);
        int n = nums.length;
        int result = nums[0] + nums[1] + nums[n-1];
        for(int i=0;i<n-2;i++){
            int low = i+1, high = n-1;
            while(low<high){
                int sum = nums[i] + nums[low] + nums[high];
                if(sum > target) high--;
                else low++;
                if(Math.abs(sum - target) < Math.abs(result - target)) result = sum;
            }
        }
        return result;
    }
}