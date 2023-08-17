class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int i = 0, j = numbers.length - 1;
        // while(i < j){
        //     if(numbers[i] + numbers[j] == target){
        //         return new int[]{i+1,j+1};
        //     }else if(numbers[i] + numbers[j] < target){
        //         i++;
        //     }else j--;
        // }
        // return new int[]{-1,-1};
        int i = 0, j = nums.length - 1;
        while(i<j){
            if(nums[i] + nums[j] == target) return new int[]{i+1,j+1};
            else if(nums[i] + nums[j] < target) i++;
            else j--;
        }
        return new int[]{-1,-1};
    }
}