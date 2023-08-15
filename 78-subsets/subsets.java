class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0,nums,ans,new ArrayList<>());
        return ans;
    }
    public void solve(int idx,int[] nums,List<List<Integer>> ans,List<Integer> ds){
        if(idx == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[idx]);
        solve(idx+1,nums,ans,ds);
        ds.remove(ds.size()-1);
        solve(idx+1,nums,ans,ds);
    }
}