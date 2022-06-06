// Find the duplicate in an array of N+1 integers
// Problem Statement: Given an array of N + 1 size, where each element is between 1 and N. Assuming there is only one duplicate number, your task is to find the duplicate number.

class Solution {
    public int findDuplicate(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(nums[i] != i+1){
                if(nums[i] != nums[nums[i] - 1]){
                    swap(nums,i,nums[i]-1);
                }else return nums[i];
            }else i++;
        }
        return -1;
    }
    public static void swap(int[] arr,int i1,int i2) {
        var temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
