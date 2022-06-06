// Find the duplicate in an array of N+1 integers
// Problem Statement: Given an array of N + 1 size, where each element is between 1 and N. Assuming there is only one duplicate number, your task is to find the duplicate number.
// Time complexity: O(N). Since we traversed through the array only once.
// Space complexity: O(1).

class Solution {
  public int findDuplicate(int[] nums) {
    int slow = nums[0];
    int fast = nums[0];
    do{
      slow = nums[slow];
      fast = nums[nums[fast]];
    }while(slow!=fast);

    fast = nums[0];
    while(slow!=fast){
      slow = slow.get(slow);
      fast = fast.get(fast);
    }
    return slow;
  }
}
