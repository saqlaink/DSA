class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        sum(0,arr,target,res,new ArrayList<>());
        return res;
    }
    public static void sum(int idx,int[] arr,int k,List<List<Integer>> res,ArrayList<Integer> ds){
        if(k == 0){
            res.add(new ArrayList<>(ds));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if(i > idx && arr[i] == arr[i-1]) continue;
            if(arr[i] > k) break;
            ds.add(arr[i]);
            sum(i+1,arr,k - arr[i], res,ds);
            ds.remove(ds.size() - 1);
        }
    }
}