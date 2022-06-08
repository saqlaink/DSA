// 4 Sum | Find Quads that add up to a target value
// Problem Statement: Given an array of N integers, your task is to find unique quads that add up to give a target value. In short, you need to return an array of all the unique quadruplets [arr[a], arr[b], arr[c], arr[d]] such that their sum is equal to a given target.


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      int n = nums.length;
      Arrays.sort(nums);
      List<List<Integer>> result = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        if (i > 0 && nums[i - 1] == nums[i]) continue;
        threeSum(nums, i + 1, n - 1, target - nums[i], result);
      }
      return result;
    }

    public void threeSum(int[] nums, int lo, int hi, int target, List<List<Integer>> res) {
      int n = nums.length;
      int subLen = hi - lo + 1;
      for (int i = lo;i <= hi;i++) {
        if (i > lo && nums[i] == nums[i - 1]) continue;  // skip same result
        // two pointers
        int j = i + 1, k = hi;
        int t = target - nums[i];
        while (j < k) { // each element is only used once
          if (nums[j] + nums[k] < t) {
            ++j;
          } else if (nums[j] + nums[k] > t) {
            --k;
          } else { // equal
            res.add(Arrays.asList(nums[lo - 1], nums[i], nums[j], nums[k]));
            ++j;
            --k;
            while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
            while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
          }
        }
      }
    }
}