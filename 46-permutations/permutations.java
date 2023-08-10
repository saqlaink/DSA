class Solution {
    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recur(0,nums,ans);
        return ans;
    }
    public void recur(int idx,int[] nums,List<List<Integer>> ans){
        if(idx == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++) ds.add(nums[i]);
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(i,idx,nums);
            recur(idx+1,nums,ans);
            swap(idx,i,nums);
        }
    }
}