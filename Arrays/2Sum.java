// Two Sum : Check if a pair with given sum exists in Array
// Problem Statement: Given an array of integers nums[] and an integer target, return indices of the two numbers such that their sum is equal to the target.

// Note: Assume that there is exactly one solution, and you are not allowed to use the same element twice. Example: If target is equal to 6 and num[1] = 3, then nums[1] + nums[1] = target is not a solution.
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for(int i=0;i<nums.length;i++){
            int num = target - nums[i];
            if(map.containsKey(num)){
                arr[0] = map.get(num);
                arr[1] = i;
                return arr;
            }
            map.put(nums[i],i);
        }
        return arr;
    }
}